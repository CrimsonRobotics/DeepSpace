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



  public static int DT_FRONTLEFT = 52;
	public static int DT_BACKLEFT = 51;
	public static int DT_FRONTRIGHT = 57;
  public static int DT_BACKRIGHT= 58; 
   
  //public static int DT_FRONTLEFT = 0;
	//public static int DT_BACKLEFT = 0;
	//public static int DT_FRONTRIGHT = 0;
  //public static int DT_BACKRIGHT= 0;

  public static int Elevator1 = 6;
  public static int Elevator2 = 7;
  public static int limitSwitch1= 1;
  public static int limitSwitch2 = 2;

  public static int climberBackRight = 4;
  public static int climberBackLeft =  3;
  public static int climberFrontRight = 0;
  public static int climberFrontLeft = 0;

  public static int climberWheelL = 0;
  public static int climberWheelR = 0;

  public static int arm = 0;
  //53
 // public WPI_TalonSRX climberBackLeft;
  //climberBackLeft = new WPI_TalonSRX(3);

  public static int intake2 = 55;
  public static int intake1 = 54;
  //54;
  public static int mod = 59;
  public static int clawS = 1;
  public static int dropper1 = 3;
  public static int dropper2 = 0;
  public static int dropper3 = 0;
  public static int dropper4 = 0;
  public static int dropper5 = 0;
  public static int dropper6 = 0;
  public static int centerS = 3;
  public static int grabberS = 0;
  public static int grabberS2 = 1;
  public static int grabberS3 = 0;
  public static int grabberS4 = 0;
  //public static int Shifty = 0;
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
