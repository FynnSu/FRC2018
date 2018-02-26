package org.usfirst.frc.team6141.commands;

import org.usfirst.frc.team6141.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberUpCommand extends Command {

    public ClimberUpCommand() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.control.climber);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.control.climber.setSpeed(1);
    }

    protected void end() {
    	Robot.control.climber.stop();
    }
    
    protected void interrupted() {
    	end();
    }
    
	protected boolean isFinished() {
		return false;
	}

}
