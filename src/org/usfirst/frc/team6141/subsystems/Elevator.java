package org.usfirst.frc.team6141.subsystems;

import org.usfirst.frc.team6141.commands.ElevatorCommand;
import org.usfirst.frc.team6141.robot.RobotConst;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem{
	
	private Spark motor;
	
	public Elevator() {
		motor = new Spark(RobotConst.ELEVATOR_MOTOR_PWM_PORT);
	}
	
	public void setSpeed(double speed) {
		motor.set(speed);
	}
	
	public void stop() {
		motor.stopMotor();
	}
	
	public void update() {
		SmartDashboard.putNumber("Elevator Power", motor.getSpeed());
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ElevatorCommand());
	}

}
