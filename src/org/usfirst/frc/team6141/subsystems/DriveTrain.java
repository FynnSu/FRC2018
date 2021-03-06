package org.usfirst.frc.team6141.subsystems;

import org.usfirst.frc.team6141.commands.JoystickCommand;
import org.usfirst.frc.team6141.robot.RobotConst;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    private VictorSP leftOne;
    private VictorSP leftTwo;
    private VictorSP rightOne;
    private VictorSP rightTwo;

    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickCommand());
    }
    
    public DriveTrain() {
    	leftOne = new VictorSP(RobotConst.LEFT_MOTOR_ONE_PWM_PORT);
    	leftTwo = new VictorSP(RobotConst.LEFT_MOTOR_TWO_PWM_PORT);
    	rightOne = new VictorSP(RobotConst.RIGHT_MOTOR_ONE_PWM_PORT);
    	rightTwo = new VictorSP(RobotConst.RIGHT_MOTOR_TWO_PWM_PORT);
    }
    
    public void setSpeed(double leftSpeed, double rightSpeed) {
    	leftOne.set(leftSpeed);
    	leftTwo.set(leftSpeed);
    	rightOne.set(rightSpeed);
    	rightTwo.set(rightSpeed);
    }
    
    public void setSpeedAndTurn(double speed, double turn) {
    	double leftSpeed = -speed + turn;
		double rightSpeed = speed + turn;
		
		if (leftSpeed > 1.0) leftSpeed = 1.0;
		if (leftSpeed < -1.0) leftSpeed = -1.0;
		if (rightSpeed > 1.0) rightSpeed = 1.0;
		if (rightSpeed < -1.0) rightSpeed = -1.0;
		
		setSpeed(leftSpeed, rightSpeed);
    }
    
    public void update() {
    	SmartDashboard.putNumber("Drive LeftSpeed", leftOne.getSpeed());
    	SmartDashboard.putNumber("Drive RightSpeed", rightOne.getSpeed());
    }
}

