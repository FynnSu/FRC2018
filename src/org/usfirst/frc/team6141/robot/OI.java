package org.usfirst.frc.team6141.robot;

import org.usfirst.frc.team6141.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * Driver Joystick
 * -----------------------------------------------------------
 * 
 * Axis
 * ---------------
 * Y 			Speed
 * X			
 * Z			Turn
 * 
 * Buttons
 * --------------
 * 1			Forward/Backward Drive Toggle
 * 2			Precision Drive Toggle
 * 3
 * 4
 * 5
 * 6
 * 7			Cancel Current Commands
 * 8			Straight Drive Toggle
 * 9			Drive Straight At Half Speed
 * 10			Drive Straight At Quarter Speed
 * 11			
 * 12			
 * 
 * 
 * Operator Joystick
 * -----------------------------------------------------------
 * Axis
 * ----------------
 * L Y			Elevator Up/Down
 * L X			
 * R Y			Intake In/Out
 * R X			Intake Rotate
 * L Trigger
 * R Trigger
 * 
 * Buttons
 * ---------------
 * A			
 * B			
 * X			Cancel Current Commands
 * Y			Reset Gyro
 * Start
 * Reset
 * L1			
 * R1			
 * 
 * POV
 * --------------
 * Up			Rotate To 0 degrees
 * Down			Rotate To 180 degrees
 * Left			Rotate To 270 degrees
 * Right		Rotate To 90 degrees
 * 
 */
public class OI {
	
	//Joystick Ports
	private static final int JOYSTICK_DRIVER_PORT = 0;
	private static final int JOYSTICK_OPERATOR_PORT = 1;
	
	//Driver Joystick Toggle Ports
	private static final int TOGGLE_DRIVE_STRAIGHT_PORT = 8;
	private static final int TOGGLE_DRIVE_PRECISION_PORT = 2;
	private static final int TOGGLE_DRIVE_BACKWARD_PORT = 1;
	
	//Operator Joystick Button Ports
	private static final int BUTTON_OPERATOR_CANCEL_PORT = 3;
	private static final int BUTTON_RESET_PORT = 4;
	private static final int BUTTON_CLIMBER_UP_PORT = 1;
	private static final int BUTTON_CLIMBER_DOWN_PORT = 2;
	
	
	//Driver Joystick Button Ports
	private static final int BUTTON_DRIVER_CANCEL_PORT = 7;
	private static final int BUTTON_DRIVE_STRAIGHT_HALF_SPEED_PORT = 9;
	private static final int BUTTON_DRIVE_STRAIGHT_QUARTER_SPEED_PORT = 10;
	
	//Operator Axis Ports
	private static final int OPERATOR_RIGHT_Y_AXIS = 4;
	private static final int OPERATOR_RIGHT_X_AXIS = 5;
	private static final int OPERATOR_LEFT_Y_AXIS = 0;
	
	//Joysticks
	private Joystick driver 							= new Joystick(JOYSTICK_DRIVER_PORT);
	private Joystick operator 							= new Joystick(JOYSTICK_OPERATOR_PORT);
	
	//Toggles
	private Toggle driveStraight 						= new Toggle(driver, TOGGLE_DRIVE_STRAIGHT_PORT, false);
	private Toggle drivePrecision 						= new Toggle(driver, TOGGLE_DRIVE_PRECISION_PORT, false);
	private Toggle driveBackward 						= new Toggle(driver, TOGGLE_DRIVE_BACKWARD_PORT, false);
	
	//Operator Joystick Buttons
	private JoystickButton operatorCancel 				= new JoystickButton(operator, BUTTON_OPERATOR_CANCEL_PORT);
	private JoystickButton reset						= new JoystickButton(operator, BUTTON_RESET_PORT);
	private JoystickButton climberUp 					= new JoystickButton(operator, BUTTON_CLIMBER_UP_PORT);
	private JoystickButton climberDown 					= new JoystickButton(operator, BUTTON_CLIMBER_DOWN_PORT);
	
	//Driver Joystick Buttons
	private JoystickButton driverCancel 				= new JoystickButton(driver, BUTTON_DRIVER_CANCEL_PORT);
	private JoystickButton driveStraightHalfSpeed 		= new JoystickButton(driver, BUTTON_DRIVE_STRAIGHT_HALF_SPEED_PORT);
	private JoystickButton driveStraightQuarterSpeed 	= new JoystickButton(driver, BUTTON_DRIVE_STRAIGHT_QUARTER_SPEED_PORT);
	
	/**
	 * Bind Buttons To Commands
	 */
	public OI() {
		//Operator Buttons
		operatorCancel.whenPressed(new CancelCommand());
		reset.whenPressed(new ResetCommand());
		climberUp.whileHeld(new ClimberUpCommand());
		climberDown.whileHeld(new ClimberDownCommand());
		
		//Driver Buttons
		driverCancel.whenPressed(new CancelCommand());
		
		
		//TODO use these for RobotConst calibration
		driveStraightHalfSpeed.whenPressed(new DriveForSetTimeCommand(Robot.control.gyro.getAngle(), 0.5, 1));
		driveStraightQuarterSpeed.whenPressed(new DriveForSetTimeCommand(Robot.control.gyro.getAngle(), 0.25, 1));
	}
	
	/**
	 * @return Speed value (-1 to 1)
	 */
	public double getSpeed() {return driver.getY();}
	
	/**
	 * @return Turn value (-1 to 1)
	 */
	public double getTurn() {return driver.getZ();}
	
	public double getLY() {return operator.getRawAxis(OPERATOR_LEFT_Y_AXIS);}
	
	public double getRY() {return operator.getRawAxis(OPERATOR_RIGHT_Y_AXIS);}
	public double getRX() {return operator.getRawAxis(OPERATOR_RIGHT_X_AXIS);}
	
	
	//Get Toggle Values
	public boolean isStraightDrive() {return driveStraight.getToggle();}
	public boolean isPrecisionDrive() {return drivePrecision.getToggle();}
	public boolean isBackwardDrive() {return driveBackward.getToggle();}
	
	/**
	 * Update the OI class.
	 * Called during the periodic components of robot sequence
	 * Displays data on SmartDashboard and checks the POV for a value
	 */
	public void update() {
		SmartDashboard.putString("Driver", driver.getName());
		SmartDashboard.putNumber("Driver Speed", getSpeed());
		SmartDashboard.putNumber("Driver Turn", getTurn());
		SmartDashboard.putBoolean("Straight Drive", isStraightDrive());
		SmartDashboard.putBoolean("Precision Drive", isPrecisionDrive());
		SmartDashboard.putBoolean("Backward Drive", isBackwardDrive());
	}
	
	public int getPOV() {
		return operator.getPOV();
	}
	
	
	/**
	 * Toggle Class that stores values for a toggle object and handles 
	 * button presses for desired joystick button
	 *
	 */
	public class Toggle {
		private boolean toggle;
		
		public Toggle(Joystick joystick, int port, boolean start) {
			JoystickButton button = new JoystickButton(joystick, port);
			button.whenPressed(new UpdateToggleCommand());
			toggle = start;
		}
		
		public boolean getToggle() {
			return toggle;
		}
		
		public void setToggle(boolean value) {
			toggle = value;
		}
		
		public class UpdateToggleCommand extends InstantCommand {
			@Override
			protected void initialize() {
				toggle = !toggle;
			}
		}		
	}
}
