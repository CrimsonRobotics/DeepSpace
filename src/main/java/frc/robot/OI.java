/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeStop;
import frc.robot.commands.MiniWheelStop;
import frc.robot.commands.Outtakeslow;
import frc.robot.commands.Shift;
import frc.robot.commands.StopClimber;
import frc.robot.commands.Unshift;

import frc.robot.commands.CenterIn;
import frc.robot.commands.ArmShift;
import frc.robot.commands.ArmUnshift;
import frc.robot.commands.BackDown;

import frc.robot.commands.CenterOut;
import frc.robot.commands.ClawIn;
import frc.robot.commands.ClawOut;
import frc.robot.commands.ClimberMiniWheelReverseTest;
import frc.robot.commands.ClimberMiniWheelTest;
import frc.robot.commands.ClimberTestBackDown;
import frc.robot.commands.ClimberTestBackStop;
import frc.robot.commands.ClimberTestBackUp;
import frc.robot.commands.ClimberTestDown;
import frc.robot.commands.ClimberTestFrontDown;
import frc.robot.commands.ClimberTestFrontStop;
import frc.robot.commands.ClimberTestFrontUp;
import frc.robot.commands.ClimberTestHold;
import frc.robot.commands.ClimberTestStop;
import frc.robot.commands.ClimberTestUp;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.Drop;
import frc.robot.commands.DropperUp;
import frc.robot.commands.FrontDown;
import frc.robot.commands.Grab;
import frc.robot.commands.HatchSequentialAquire;
import frc.robot.commands.HatchSequentialDeliver;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private Joystick driverLeft = new Joystick(0); // Joysticks are defined; Joystick "driverLeft" is in port 0
  private Joystick driverRight = new Joystick(1); // Joysticks are defined; Joystick "driverright" is in port 1
  private Joystick coDriver = new Joystick(2);
  // private JoystickButton intake = new JoystickButton(coDriver, 1);
  // private JoystickButton climberButton = new JoystickButton(coDriver, 2);

  private JoystickButton intake = new JoystickButton(coDriver, 2);
  private JoystickButton intake2 = new JoystickButton(coDriver, 1);
 private JoystickButton miniWheels = new JoystickButton(coDriver, 5);
  //private JoystickButton climberFrontDown = new JoystickButton(coDriver,6);
  private JoystickButton climberTestUp = new JoystickButton(coDriver,6);
  private JoystickButton climberTestStop = new JoystickButton(coDriver,4);
  //private JoystickButton climberBackTestUp = new JoystickButton(coDriver,6);
  private JoystickButton climberBackTestDown = new JoystickButton(coDriver,10);
 // private JoystickButton climberFrontTestUp = new JoystickButton(coDriver,0);
  private JoystickButton climberFrontTestDown = new JoystickButton(coDriver,11);
  //private JoystickButton MiniWheels = new JoystickButton(coDriver, 4);
  private JoystickButton miniWheelsReverse = new JoystickButton(driverLeft, 6);
  
//  private JoystickButton clawButton = new JoystickButton(coDriver, 7);//punch
//  private JoystickButton centerButton = new JoystickButton(coDriver, 9);

private JoystickButton hatchSequentialAquireButton = new JoystickButton(coDriver,7);
private JoystickButton hatchSequentialDeliverButton = new JoystickButton(coDriver,9);
  
  private JoystickButton shifter = new JoystickButton(driverLeft, 1);
  private JoystickButton intake3 = new JoystickButton(coDriver, 3);

  private JoystickButton armShifter = new JoystickButton(coDriver, 12);





  public OI() {

    hatchSequentialAquireButton.whenPressed(new HatchSequentialAquire());
    hatchSequentialDeliverButton.whenPressed(new HatchSequentialDeliver());
    intake.whenPressed(new IntakeOut());
    intake.whenReleased(new IntakeStop());
    intake2.whenPressed(new IntakeIn()); 
    intake2.whenReleased(new IntakeStop());
    intake3.whenPressed(new Outtakeslow());
    intake3.whenReleased(new IntakeStop());
    
   /* 
    climberButton.whileHeld(new ClimberUp());
    climberButton.whenReleased(new StopClimber());
    climberBackDown.whileHeld(new BackDown());
    climberBackDown.whenReleased(new StopClimber());
    climberFrontDown.whileHeld(new FrontDown());
    climberFrontDown.whenReleased(new StopClimber());
*/
    climberTestUp.whileHeld(new ClimberTestUp());
    climberTestUp.whenReleased(new ClimberTestHold());

    climberTestStop.whenPressed(new ClimberTestStop());
/*
    climberBackTestUp.whileHeld(new ClimberTestBackUp());
    climberBackTestUp.whenReleased(new ClimberTestBackStop());
*/
    climberBackTestDown.whileHeld(new ClimberTestBackDown());
    climberBackTestDown.whenReleased(new ClimberTestBackStop());

    climberFrontTestDown.whileHeld(new ClimberTestFrontDown());
    climberFrontTestDown.whenReleased(new ClimberTestFrontStop());
/*
    climberFrontTestUp.whileHeld(new ClimberTestFrontUp());
    climberFrontTestUp.whenReleased(new ClimberTestFrontStop());*/
    miniWheels.whileHeld(new ClimberMiniWheelTest());
    miniWheels.whenReleased(new MiniWheelStop());

    miniWheelsReverse.whileHeld(new ClimberMiniWheelReverseTest());
    miniWheelsReverse.whenReleased(new MiniWheelStop());

  /*  clawButton.whileHeld(new ClawIn());
    clawButton.whenReleased(new ClawOut());
  
    centerButton.whenPressed(new CenterOut());
    centerButton.whenReleased(new CenterIn());*/
    shifter.whenPressed(new Shift());
    shifter.whenReleased(new Unshift());
    armShifter.whenPressed(new ArmShift());//if changed, change to whenPressed
    armShifter.whenReleased(new ArmUnshift());
//    armShifter2.whenPressed(new ArmUnshift());
		//
		//dhs
	}
	
	
	
	public Joystick getcoDriver(){
		
		return coDriver;
	}
	
	public Joystick getDriverLeft(){
		
		return driverLeft;
	}
	
	public  Joystick getDriverRight(){
		
		return driverRight;
	}
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
