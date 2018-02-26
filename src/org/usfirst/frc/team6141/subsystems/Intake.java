package org.usfirst.frc.team6141.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6141.commands.IntakeCommand;
import org.usfirst.frc.team6141.robot.RobotConst;

/**
 *
 */
public class Intake extends Subsystem {
	
	private Spark leftMotor;
	private Spark rightMotor;
	
	public Intake() {
		leftMotor = new Spark (RobotConst.LEFT_INTAKE_MOTOR_PWM_PORT);
		rightMotor = new Spark(RobotConst.RIGHT_INTAKE_MOTOR_PWM_PORT);
	}

	public void setSpeed(double leftIntake, double rightIntake) {
		leftMotor.set(leftIntake);
		rightMotor.set(rightIntake);
	}
	
	public void setSpeedAndTurn(double speed, double turn) {
		double leftSpeed = speed + turn;
		double rightSpeed = - speed + turn;
		
		setSpeed(leftSpeed, rightSpeed);
	}
	
	public void stop() {
		leftMotor.stopMotor();
		rightMotor.stopMotor();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void update() {
		SmartDashboard.putNumber("Intake Left Motor Speed", leftMotor.getSpeed());
		SmartDashboard.putNumber("Intake Right Motor Speed",  rightMotor.getSpeed());
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeCommand());
    }
}

