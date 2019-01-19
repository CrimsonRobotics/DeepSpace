/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int DT_FRONTLEFT = 4;
	public static int DT_BACKLEFT = 3;
	public static int DT_FRONTRIGHT = 11;
  public static int DT_BACKRIGHT= 9;
  
}
	
	
	// public and static are just modifiers so don't worry about them.
    // int is an integer and those numbers are the talon IDs
	// DT_FRONTLEFT is just the name we are using so we know which of the 4 talons we are referencing
	 
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	//public static int SHOOT_L = 1;
	//public static int SHOOT_R = 2;
	
	//public static int Elevator_L = 5;
	//public static int Elevator_R = 6;
	//public static int LIMITUP = 1;
	//public static int LITMITLOW = 2;


	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

