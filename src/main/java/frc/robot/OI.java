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
import frc.robot.commands.Outtakeslow;
import frc.robot.commands.Shift;
import frc.robot.commands.Unshift;
import frc.robot.commands.BackDown;
import frc.robot.commands.CenterOut;
import frc.robot.commands.ClawIn;
import frc.robot.commands.ClawOut;

//import edu.wpi.first.wpilibj.buttons;

import frc.robot.commands.ClimberUp;
import frc.robot.commands.Drop;
import frc.robot.commands.DropperUp;
import frc.robot.commands.FrontDown;
import frc.robot.commands.Grab;

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
  private JoystickButton climberButton = new JoystickButton(coDriver, 4);
  private JoystickButton climberBackDown = new JoystickButton(coDriver,5);
  private JoystickButton climberFrontDown = new JoystickButton(coDriver,6);

  private JoystickButton clawButton = new JoystickButton(coDriver, 7);
  private JoystickButton dropperButton = new JoystickButton(coDriver, 8);
  private JoystickButton grabberButton = new JoystickButton(coDriver, 9);
  private JoystickButton centerButton = new JoystickButton(coDriver, 10);
  private JoystickButton shifter = new JoystickButton(driverLeft, 2);
  private JoystickButton intake3 = new JoystickButton(coDriver, 3);

  //
  public OI() {

    intake.whenPressed(new IntakeOut());
    intake.whenReleased(new IntakeStop());
    intake2.whenPressed(new IntakeIn()); 
    intake2.whenReleased(new IntakeStop());
    intake3.whenPressed(new Outtakeslow());
    intake3.whenReleased(new IntakeStop());
    
    
    climberButton.whileHeld(new ClimberUp());
    climberBackDown.whileHeld(new BackDown());
    climberFrontDown.whileHeld(new FrontDown());

    clawButton.whenPressed(new ClawIn());
    clawButton.whenReleased(new ClawOut());
    dropperButton.whenPressed(new Drop());
    dropperButton.whenReleased(new DropperUp());
    grabberButton.whenPressed(new Grab());
    centerButton.whenPressed(new CenterOut());
    shifter.whenPressed(new Shift());
    shifter.whenReleased(new Unshift());
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
