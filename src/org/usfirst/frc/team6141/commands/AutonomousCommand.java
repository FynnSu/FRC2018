package org.usfirst.frc.team6141.commands;

import org.usfirst.frc.team6141.misc.AutoMode;
import org.usfirst.frc.team6141.misc.GameData;
import org.usfirst.frc.team6141.misc.Setting;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	
	//TODO test all coded autonomous modes
    public AutonomousCommand(AutoMode auto, GameData data) {
    	
    	
    	
    	    	
    	double inchesToMetersMultiplier = 0.0254;
    	addSequential(new DriveToUltrasonicDistanceCommand(0.0, 0.5, 80 * inchesToMetersMultiplier, 4.0));
//    	double dToSwitch = 3; //meters
//    	
//    	switch(auto) {
//    	case CROSS_LINE:
//    		addSequential(new DriveToUltrasonicDistanceCommand(0.0, 0.5, 80 * inchesToMetersMultiplier, 4.0));
//    		break;
//    	case SWITCH:
//    		int loc = data.getLocation();
//    		Setting swi = data.getSwitch();
//    		if (loc == 1 && swi == Setting.LEFT) {
//    			addSequential(new DriveToUltrasonicDistanceCommand(0.0, 0.5, dToSwitch, 4.0));
//    			addSequential(new FoldUpCommand());
//    			addSequential(new IntakeOutCommand());		
//    		} else if (loc == 3 && swi == Setting.RIGHT) {
//    			addSequential(new DriveToUltrasonicDistanceCommand(0.0, 0.5, dToSwitch, 4.0));
//    			addSequential(new FoldUpCommand());
//    			addSequential(new IntakeOutCommand());	
//    		} else {
//    			addSequential(new DriveToUltrasonicDistanceCommand(0.0, 0.5, 80 * inchesToMetersMultiplier, 4.0));
//    		}    		
//    		
//    		break;
//    	case SCALE:
//    		
//    		break;
//    	
//    	}
    	
//    		addSequential(new DriveForSetTimeCommand(180, -0.5, 2.5));
//    		break;
//    	case LEFT_GEAR:
//    		addSequential(new DriveToUltrasonicDistanceCommand(180, -0.5, 75 
//					* inchesToMetersMultiplier));
//			addSequential(new RotateToHeadingCommand(239));
//			addSequential(new DriveForSetTimeCommand(239, -0.25, 28 
//					* inchesToMetersMultiplier 
//					* RobotConst.DISTANCE_METERS_TO_TIME_QUARTER_SPEED_MULTIPLIER));
//			addSequential(new DelayCommand(3));
//			addSequential(new DriveForSetTimeCommand(239, 0.5, 30 
//					* inchesToMetersMultiplier 
//					* RobotConst.DISTANCE_METERS_TO_TIME_HALF_SPEED_MULTIPLIER));
//			break;
//    	case CENTER_GEAR:
//    		addSequential(new DriveToUltrasonicDistanceCommand(180, -0.5,  84 
//					* inchesToMetersMultiplier));
//    		break;
//    	case RIGHT_GEAR:
//    		addSequential(new DriveToUltrasonicDistanceCommand(180, -0.5, 94 
//					* inchesToMetersMultiplier));
//			addSequential(new RotateToHeadingCommand(121));
//			addSequential(new DriveForSetTimeCommand(121, -0.25, 28 
//					* inchesToMetersMultiplier 
//					* RobotConst.DISTANCE_METERS_TO_TIME_QUARTER_SPEED_MULTIPLIER));
//			addSequential(new DelayCommand(3));
//			addSequential(new DriveForSetTimeCommand(121, 0.5, 30 
//					* inchesToMetersMultiplier 
//					* RobotConst.DISTANCE_METERS_TO_TIME_HALF_SPEED_MULTIPLIER));
//			break;
//    	}
    
    }
}
 