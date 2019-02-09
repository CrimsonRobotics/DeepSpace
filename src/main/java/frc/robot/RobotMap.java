/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {



  public static int DT_FRONTLEFT = 2;
	public static int DT_BACKLEFT = 1;
	public static int DT_FRONTRIGHT = 8;
  public static int DT_BACKRIGHT= 7;
   
  //public static int DT_FRONTLEFT = 0;
	//public static int DT_BACKLEFT = 0;
	//public static int DT_FRONTRIGHT = 0;
  //public static int DT_BACKRIGHT= 0;

  public static int Elevator1 = 6;
  public static int Elevator2 = 7;
  public static int lm1= 1;
  public static int lm2 = 2;

  public static int climberBackRight = 0;
  public static int climberBackLeft =  0;
  public static int climberFrontRight = 0;
  public static int climberFrontLeft = 0;
 // public WPI_TalonSRX climberBackLeft;
  //climberBackLeft = new WPI_TalonSRX(3);

  public static int intake1 = 31;
  public static int intake2 = 32;

  public static int shoot1 = 17;
  public static int shoot2 = 18;

 // public static int clawS = 1;
  public static int dropperS = 3;
 // public static int centerS = 3;
  public static int grabberS = 0;
  public static int grabberS2 = 1;
 // public static int centerS2 = 6;
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
