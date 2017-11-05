package com.Team5427.testing;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5427.robot.Robot;
import com.Team5427.res.Config;
import com.Team5427.res.Log;

/**
 * This class uses the numbers from the networkTable to tell the robot which direction it needs to move to align with the goal
 */

public class autoHorizontalAlignGoalCommand {
	
	public autoHorizontalAlignGoalCommand() {
		// Use requires() here to declare subsystem dependencies
   
		requires(Robot.driveTrain);
		NetworkTable table = NetworkTable.getTable("datatable");
	}

	/**i m
	 * TODO comment
	 */
	@SuppressWarnings("all")
	protected void execute() {
		
		SmartDashboard.putNumber("Time", getTime());
		
		Log.info("Time:"+getTime());
		Log.info("Pos:"+position);
	}	
	
//  public void updateDistanceStatus()	{
//  if(getTowerDistanceTurret() < MIN_DISTANCE)
//      distanceStatus = MOVE_BACK;
//  else if(getTowerDistanceTurret() > MAX_DISTANCE)
//      distanceStatus = MOVE_FORWARD;
//  else if(getTowerDistanceTurret() > MIN_DISTANCE && getTowerDistanceTurret() < MAX_DISTANCE)
//      distanceStatus = SPOT_ON;
//  else
//      distanceStatus = Integer.MIN_VALUE;
//}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}