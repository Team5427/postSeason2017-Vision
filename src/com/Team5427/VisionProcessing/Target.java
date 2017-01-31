package com.Team5427.VisionProcessing;

import com.Team5427.res.Config;
import com.Team5427.res.Log;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Charlemagne Wong on 1/29/2017.
 */

//contains information about the different aspects about the tapee-goals marking the boilers
public class Target {

    /**
     * Vars to determine if target is top or bottom of the retroreflective tape
     */
    public static int TOP = 0;
    public static int BOTTOM = 1;

    /**
     * List of lines that applies to the target
     */
    private ArrayList<Line> lineList;

    /**
     * Contour for the lines that apply to the target
     */
    private MyContour contour;

    /**
     * Peak point as a reference to find distance between the camera and the target
     */
    private Point2D.Double peak;

    /**
     * Type of the class, whether it is a top target or bottom target
     */
    private int type = -1;

    /**
     * Angle of elevation from the camera to the target. Default 0 degrees if the angle has not been calculated yet
     */
    private double angleOfElevation = 0;
    
    /**
     * Distance from the camera itself to the goal
     */
    private double cameraDistanceToGoal = 0;



    /**
     * Determines if angle of elevation has been calculated. If true, the boolean will be true and false otherwise
     */
    private boolean b_angleOfElevation = false;
    
    /**
     * camera
     */
    private double cameraDistanceToTower = Double.MIN_VALUE;
    
    /**
     *
     * @param lineList
     * @param contour
     * @param peak
     * @param type
     */
    public Target(ArrayList<Line> lineList, MyContour contour, Point2D.Double peak, int type) {
        this.contour = contour;
        this.lineList = lineList;
        this.peak = peak;
        this.type = type;
    }

    public ArrayList<Line> getLineList() {
        return lineList;
    }

    public void setLineList(ArrayList<Line> lineList) {
        this.lineList = lineList;
    }

    public MyContour getCountour() {
        return contour;
    }

    public void setCountour(MyContour countour) {
        this.contour = countour;
    }

    public Point2D.Double getPeak() {
        return peak;
    }

    public void setPeak(Point2D.Double peak) {
        this.peak = peak;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {this.type = type;}

    public double getAngleOfElevation() {
        /*
		 * System.out.println((GraphicsPanel.RESOLUTION.getHeight() / 2 -
		 * (leftLine.getTopPointY() + rightLine.getTopPointY()) / 2));
		 */

        if (b_angleOfElevation == false) {
            angleOfElevation = Math.atan((GraphicsPanel.RESOLUTION.getHeight() / 2
                - peak.getY() / GraphicsPanel.pixelsToGoal)
                + Math.toRadians(Config.CAMERA_START_ANGLE));

            b_angleOfElevation = true;
        }

        return angleOfElevation;

		/*
		 * return Math .atan(((leftLine.getMidpointY() +
		 * rightLine.getMidpointY()) / 2 - GraphicsPanel.RESOLUTION.getHeight() /
		 * 2) / GraphicsPanel.pixelsToGoal) +
		 * Math.toRadians(Config.CAMERA_START_ANGLE);
		 */
	}
    

    public double getCameraDistanceToGoal()
    {
    	return cameraDistanceToGoal;
    }
    
//    public void setCameraDistanceToGoal()
//    {
//    	Double distance=null;
//    	
//    	distance=
//    	
//    	cameraDistanceToGoal=distance;
//    }
    
    /**
     * Returns the distance from the camera to the tower (horizontal disntance)
     * 
     * @return Returns the distance from the camera to the tower (horizontal disntance)
     */
/*    public double getCameraDistanceToTower()	{
    	if(cameraDistanceToTower == Double.MIN_VALUE)	{
    		cameraDistanceToTower = Math.sqrt(Math.pow(,2)+Math.pow(,2));
    	}
    	return cameraDistanceToTower;
    }
*/
}