package org.usfirst.frc.team6141.subsystems;

import org.usfirst.frc.team6141.robot.RobotConst;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Spark motor;
	
	public Climber() {
		motor = new Spark(RobotConst.CLIMBER_MOTOR_PWM_PORT);
	}
	
	public void setSpeed(double speed) {
		motor.set(speed);
	}
	
	public void stop() {
		motor.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void update() {
    	SmartDashboard.putNumber("Climber Power",  motor.getSpeed());
    }
}

