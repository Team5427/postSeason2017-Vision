//package org.usfirst.frc.team5427.robot.commands.auto;
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
//	
//	
//	public autoHorizontalAlignGoalCommand() {
//		// Use requires() here to declare subsystem dependencies
//		requires(Robot.driveTrain);
//		//TODO fix below code
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
//		
//		
//
//	}
//
//	
//	
//	/**
//	 * 
//	 * @return returns the number of milliseconds since autonomous started
//	 */
//	protected double getTime() {
//		//return (double) ((System.nanoTime() - startTime) / 1000000000f);
//		return 0;
//	}
//
//	// Make this return true when this Command no longer needs to run execute()
//	protected boolean isFinished() {
//		
//		if(getTime()>15)
//		{
//			return true;
//		}
//		
//		
//		
//		return false;
//	}
//
//	// Called once after isFinished returns true
//	protected void end() {
//		Robot.driveTrain.stop();
//		Robot.launcher.stop();
//		Robot.gateSub.changePos(Config.GATE_CLOSED);
////		Robot.agitator.stop();
//	}
//
//	// Called when another command which requires one or more of the same
//	// subsystems is scheduled to run
//	protected void interrupted() {
//		end();
//	}
//}
