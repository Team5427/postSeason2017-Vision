//package org.usfirst.frc.team5427.robot.commands.auto;
//import org.usfirst.frc.team5427.robot.util.PackingClass;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.networktables.NetworkTable;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//import org.usfirst.frc.team5427.robot.Robot;
//import org.usfirst.frc.team5427.robot.util.Config;
//import org.usfirst.frc.team5427.robot.util.Log;
//
///**
// * this class uses the number from the networkTable to move the robot left or right.  
// * It is set on a timer.  This command should be called from AutoDrive
// */
//
//public class autoHorizontalAlignGoalCommand extends Command{
//	
//	public static NetworkTable table;
//	public static final int NEED_TO_TURN_RIGHT = 1;
//	public static final int NEED_TO_TURN_LEFT = -1;
//	public static final int CENTERED = 0;
//	
//	
//	public autoHorizontalAlignGoalCommand(double timeout) {
//		// Use requires() here to declare subsystem dependencies
//		requires(Robot.driveTrain);
//		//TODO fix below code
//		setTimeout(timeout);
//		NetworkTable table = NetworkTable.getTable("GRIP");
//				NetworkTable.setClientMode();
//		NetworkTable.setIPAddress("localhost");
//	}
//
//	//TODO check this code for autonomous
//	// Called repeatedly when this Command is scheduled to run
//
//	/**i m
//	 * TODO comment
//	 */
//	@SuppressWarnings("all")
//	protected void execute() {
//		if(CENTERED==getTurnDirectionNeeded())
//			Log.info("robot is centered");
//		if(NEED_TO_TURN_LEFT==getTurnDirectionNeeded())
//			Log.info("robot needs to turn left");	
//		if(NEED_TO_TURN_RIGHT==getTurnDirectionNeeded())
//				Log.info("robot needs to turn right");
//				
//	}
//
//	/**
//	 * returns direction the robot needs to turn, based on data input fromt the NetworkTable
//	 */
//	public int getTurnDirectionNeeded()
//	{
//		Double data = null;
//		table.getNumber("horizontalData", data);
//		Log.info("DATA is " + data);
//		//position bytes
//		byte needToMoveLeft = 0, needToMoveRight = 0, centered = 0;
//		//converts data to a byte array
//		byte [] buff = new byte[3];
//		buff= PackingClass.doubleToBytes(data);
//		//sets the different position bytes to their correct values
//		needToMoveLeft = buff [0];
//		centered = buff [1];
//		needToMoveRight = buff [2];
//		
//		if(1==centered)
//			return CENTERED;
//		if(1==needToMoveLeft&&1==needToMoveRight)
//			return CENTERED;
//		if(1==needToMoveLeft)
//			return NEED_TO_TURN_LEFT;
//		if(1==needToMoveRight)
//			return NEED_TO_TURN_RIGHT;
//		return CENTERED;
//		
//	}
//	
//	
//	/**
//	 * 
//	 * @return returns the number of milliseconds since autonomous started
//	 */
//	@Deprecated
//	protected double getTime() {
//		//return (double) ((System.nanoTime() - startTime) / 1000000000f);
//		return 0;
//	}
//
//	// Make this return true when this Command no longer needs to run execute()
//	protected boolean isFinished() {
//		
////		if(getTime()>15)
////		{
////			return true;
////		}
//		if(isTimedOut())
//			return true;
//		return false;
//	}
//
//	// Called once after isFinished returns true
//	protected void end() {
//		Robot.driveTrain.stop();
//		//Robot.launcher.stop();
//		//Robot.gateSub.changePos(Config.GATE_CLOSED);
////		Robot.agitator.stop();
//	}
//
//	// Called when another command which requires one or more of the same
//	// subsystems is scheduled to run
//	protected void interrupted() {
//		end();
//	}
//}
