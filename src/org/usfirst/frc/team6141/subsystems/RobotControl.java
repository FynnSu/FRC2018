package org.usfirst.frc.team6141.subsystems;

import org.usfirst.frc.team6141.misc.*;
import org.usfirst.frc.team6141.robot.RobotConst;
import org.usfirst.frc.team6141.sensors.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RobotControl extends Subsystem {
	
	public DriveTrain drive;
	public Intake intake;
	public Elevator elevator;
	public Climber climber;
	public F_Gyro gyro;
	public F_Ultrasonic ultrasonic;
	
	public RobotControl() {
		drive = new DriveTrain();
		intake = new Intake();
		elevator = new Elevator();
		climber = new Climber();
		gyro = new F_Gyro();
		ultrasonic = new F_Ultrasonic(RobotConst.ULTRASONIC_ANALOG_INPUT_PORT);
		ultrasonic.calibrate(RobotConst.ULTRASONIC_20_INCHES_VOLTAGE, RobotConst.ULTRASONIC_40_INCHES_VOLTAGE, RobotConst.ULTRASONIC_80_INCHES_VOLTAGE);
	}
	
	public void update() {
		drive.update();
		intake.update();
		elevator.update();
		climber.update();
		gyro.update();
		ultrasonic.update();
		//TODO Test SmartDashboard Subsystem Display
		SmartDashboard.putData("Drive", drive);
		SmartDashboard.putData("Intake", intake);
	}

    public void initDefaultCommand() {
    }
        
}

