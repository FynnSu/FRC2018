package org.usfirst.frc.team6141.commands;

import org.usfirst.frc.team6141.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {

    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.control.intake);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double intakeSpeed = Robot.m_oi.getRY();
    	double intakeTurn = Robot.m_oi.getRX();
    	double leftIntake = intakeSpeed + intakeTurn;
    	double rightIntake = -intakeSpeed + intakeTurn;
    
    	Robot.control.intake.setSpeed(leftIntake, rightIntake);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.control.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
