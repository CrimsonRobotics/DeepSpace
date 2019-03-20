/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {



  public static int DT_FRONTLEFT = 6;
	public static int DT_BACKLEFT = 5;
  public static int DT_FRONTRIGHT = 2;
  public static int DT_BACKRIGHT= 1; 

  public static int climberBackLeft = 11;
  public static int climberBackRight =  12;
  public static int climberFrontRight = 4;//was left 3/7
  public static int climberFrontLeft = 8;//was right 3/7

  public static int climberWheelL = 9;
  public static int climberWheelR = 10;

  public static int arm = 13;
  //53
 // public WPI_TalonSRX climberBackLeft;
  //climberBackLeft = new WPI_TalonSRX(3);

  public static int intake2 = 3;
  public static int intake1 = 7;
  //54;
  public static int mod = 0;
  public static int mod2 = 59;
  public static int clawS1 = 1;//mod2
  public static int clawS2 = 0;//double
  //public static int dropper1 = 1;
  //public static int dropper2 = 2;
  //public static int dropper3 = 3;
  //public static int dropper4 = 4;
  //public static int dropper5 = 5;
  //public static int dropper6 = 6;
  public static int centerS = 2;
  public static int centerS2 = 3;
  //public static int grabberS2 = 4;
  //public static int grabberS3 = 5;
  //public static int grabberS4 = 6;
  public static int ArmShifter = 0;//mod1
  public static int ArmShifter2 = 1;//mod1
  public static int Shifty = 2;
  public static int Shifty2 = 4;
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
