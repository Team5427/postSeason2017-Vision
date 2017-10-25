package com.Team5427.testing;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * this class uses the number from the networkTable to 
 */

public class autoHorizontalAlignGoalCommand {
	
	public autoHorizontalAlignGoalCommand() {
		// Use requires() here to declare subsystem dependencies
   
		requires(Robot.driveTrain);
		NetworkTables table = new 
	}

	//TODO check this code for autonomous
	// Called repeatedly when this Command is scheduled to run

	/**i m
	 * TODO comment
	 */
	@SuppressWarnings("all")
	protected void execute() {
		
		SmartDashboard.putNumber("Time", getTime());
		
		Log.info("Time:"+getTime());
		Log.info("Pos:"+position);
	
	
		if(position == Config.BLUE_AUTO_LEFT)
		{
			Log.info("BL");
			double timetoTurn = 7.7;
			if(getTime() < Config.AUTO_BLUE_LEFT_START_DRIVE_TIME)	{ 
				
			Robot.driveTrain.driveWPI(-0.3,0.08);
//				Robot.driveTrain.driveWPI(-0.3, .038875);
			}else if (getTime() < Config.AUTO_BLUE_LEFT_START_DRIVE_TIME + 3) {
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			} else if (getTime() < timetoTurn) {
				Robot.driveTrain.driveWPI(0.3, 0);
			} else if (getTime() < (timetoTurn + .2)) {
				System.out.print("waiting to turn");
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			} else if (getTime() < (timetoTurn + .2 + 2.3)) {	// 7.4
				System.out.print("turning");
				Robot.driveTrain.setLeftSpeed(-Config.AUTO_FULL_TURN_SPEED_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT);
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
			} else if (getTime() < 15) {
				Robot.driveTrain.stop();
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
//				if (getTime() > (timetoTurn + .2 + 3.3 + .1)) {
					if (!gateMoved) {
						Robot.gateSub.changePos(Config.GATE_OPEN);
						gateMoved = true;
					}
//				}
			} else {
				end();
			}
		}
		else if(position == Config.BLUE_AUTO_MIDDLE)
		{
			//testing
		//blue mid
//			Log.init("Starting Blue Autonomous Middle");
			if(getTime()<Config.AUTO_MIDDLE_START_DRIVE_TIME)
			{				
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else if(getTime()<Config.AUTO_MIDDLE_GEAR_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_BACK_OFF_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_BACKWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_BACKWARD_RIGHT);
			}
			else if(getTime()< Config.AUTO_MIDDLE_AFTER_BACK_DELAY)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
				
			}
			else if(getTime()<Config.AUTO_MIDDLE_AFTER_BACK_DELAY + 1.85)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT*-1);

			}
			else if (getTime() < Config.AUTO_MIDDLE_TURN_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime() < Config.AUTO_MIDDLE_TURN_WAIT_TIME + .25)
			{
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			} else if (getTime() < 15) {
				Robot.driveTrain.stop();
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
				if (!gateMoved) {
					Robot.gateSub.changePos(Config.GATE_OPEN);
					gateMoved = true;
				}
			} else {
				end();
			}
			
//			else if(getTime() < 15 /*<Config.AUTO_MIDDLE_SHOOT_TIME*/)
//			{
//				Robot.driveTrain.setLeftSpeed(0);
//				Robot.driveTrain.setRightSpeed(0);
//				double t = (double)(getTime() - Config.AUTO_MIDDLE_DRIVE_GOAL_TIME) % 3.5;
//					
////					if (t < 2f) {
////						Robot.agitator.setSpinSpeed(-Config.AGITATOR_SPEED);
////					} else {
////						Robot.agitator.setSpinSpeed(Config.AGITATOR_SPEED);
////					}
//			}
//			else {
//				end();
//			}

		}
		else if(position == Config.BLUE_AUTO_RIGHT)
		{
			//red right
		
			if(getTime() < Config.AUTO_RIGHT_START_DRIVE_TIME )	{ 
				Robot.driveTrain.driveWPI(-0.4,-.35);	// -.04 old too little
//				Robot.driveTrain.driveWPI(-0.3,-.32);	// -.04 old too little
			}
			 else {
				end();
			}
		}
		else if(position == Config.RED_AUTO_RIGHT)
		{
			//red right
			double timetoTurnRed = 8.2;
			if(getTime() < Config.AUTO_RIGHT_START_DRIVE_TIME )	{ 
				Robot.driveTrain.driveWPI(-0.4,-.35);	// -.04 old too little
//				Robot.driveTrain.driveWPI(-0.3,-.32);	// -.04 old too little
			}
			else if(getTime() < Config.AUTO_RIGHT_GEAR_WAIT_TIME)	{ 
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}	
			else if(getTime() < Config.AUTO_RIGHT_BACK_OFF_TIME)	{ 
				Robot.driveTrain.driveWPI(0.3,0);		}
			else if(getTime() < (Config.AUTO_RIGHT_TURN_WAIT_TIME) )	{ 
				System.out.print("waiting to turn");
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime() < (Config.AUTO_RIGHT_TURN_TO_GOAL_TIME))	{ // 3.7 too much
				System.out.print("turning");
				Robot.driveTrain.setLeftSpeed(.35);
				Robot.driveTrain.setRightSpeed(-.35);
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
			} else if (getTime() < 15) {
				Robot.driveTrain.stop();
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
//				if (getTime() > (timetoTurnRed + .2 + 3.3 + .1)) {
					if (!gateMoved) {
						Robot.gateSub.changePos(Config.GATE_OPEN);
						gateMoved = true;
					}
//				}
			} else {
				end();
			}
		}
		else if(position == Config.RED_AUTO_MIDDLE)
		{
			Log.init("Starting Red Autonomous Middle");
			if(getTime()<Config.AUTO_MIDDLE_START_DRIVE_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			}
			else if(getTime()<Config.AUTO_MIDDLE_GEAR_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_BACK_OFF_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_BACKWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_BACKWARD_RIGHT);
			}
			else if(getTime()< Config.AUTO_MIDDLE_AFTER_BACK_DELAY)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_TURN_TO_GOAL_TIME)
			{
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_TURN_SPEED_LEFT*-1);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_TURN_SPEED_RIGHT );
			}
			else if (getTime() < Config.AUTO_MIDDLE_TURN_WAIT_TIME)
			{
				Robot.driveTrain.setLeftSpeed(0);
				Robot.driveTrain.setRightSpeed(0);
			}
			else if(getTime()<Config.AUTO_MIDDLE_DRIVE_GOAL_TIME)
			{
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
				Robot.driveTrain.setLeftSpeed(Config.AUTO_FULL_SPEED_FORWARD_LEFT);
				Robot.driveTrain.setRightSpeed(Config.AUTO_FULL_SPEED_FORWARD_RIGHT);
			} else if (getTime() < 15) {
				Robot.driveTrain.stop();
				Robot.launcher.setShootSpeed(Config.SHOOTER_MOTOR_SPEED);
				if (!gateMoved) {
					Robot.gateSub.changePos(Config.GATE_OPEN);
					gateMoved = true;
				}
			} else {
				end();
			}

		}
		else if (position == Config.RED_AUTO_LEFT) {
			// redLeft
			
			if(getTime() < Config.AUTO_RED_LEFT_START_DRIVE_TIME)	{ 
			
				Robot.driveTrain.driveWPI(-0.3,0.07);
//				Robot.driveTrain.driveWPI(-0.3, .038875);
			}
			else {
				end();
			}
		}

	}

	
	
	/**
	 * 
	 * @return returns the number of milliseconds since autonomous started
	 */
	protected double getTime() {
		return (double) ((System.nanoTime() - startTime) / 1000000000f);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		
		if(getTime()>15)
		{
			return true;
		}
		
		
		
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
		Robot.launcher.stop();
		Robot.gateSub.changePos(Config.GATE_CLOSED);
//		Robot.agitator.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
