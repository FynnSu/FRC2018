package org.usfirst.frc.team6141.commands;

import org.usfirst.frc.team6141.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class JoystickCommand extends Command {
	
	private boolean isStraightDrive;
	private double straightDriveAngle;
	private final double STRAIGHT_DRIVE_TURN_RATE = 0.005;

    public JoystickCommand() {
    	requires(Robot.control.drive);
    	isStraightDrive = false;
    }

    protected void initialize() {
    }

    protected void execute() {
    	int POV = Robot.m_oi.getPOV();
    	if (POV != -1) {
    		Scheduler.getInstance().add(new RotateToHeadingCommand(POV));
    	}
    	
    	double speed = Robot.m_oi.getSpeed();
    	double turn = Robot.m_oi.getTurn();
    	
    	if (Robot.m_oi.isStraightDrive()) {
    		if (!isStraightDrive) {
    			isStraightDrive = true;
    			straightDriveAngle = Robot.control.gyro.getAngle();
    		}
    		turn = Robot.control.gyro.getAngleError(straightDriveAngle)
    				* STRAIGHT_DRIVE_TURN_RATE;
    	} else {
    		isStraightDrive = false;
    	}
    	if (Robot.m_oi.isBackwardDrive()) {
    		speed = -speed;
    	}
    	if (Robot.m_oi.isPrecisionDrive()) {
    		speed = 0.4 * speed;
    		turn = 0.4 * turn;
    	} else {
    		if (Math.abs(speed) < 0.02) {
    			speed = 0.0;
    		}
    		if (Math.abs(turn) < 0.02) {
    			turn = 0.0;
    		}
    	}
    	
    	Robot.control.drive.setSpeedAndTurn(speed, turn);
    }

    protected boolean isFinished() {
        return false;
    }
}
