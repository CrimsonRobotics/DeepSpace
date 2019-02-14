/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/



package frc.robot.subsystems;


<<<<<<< HEAD

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorControl;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
=======
>>>>>>> b530dc747a7af7cc27cbdff5fb2970c2cbebfab5
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
  WPI_TalonSRX talon1;//Left
  WPI_TalonSRX talon2;//Right
  
  public Intake(int id1, int id2){

    talon1 = new WPI_TalonSRX(id1);
    talon2 = new WPI_TalonSRX(id2);
  
  }

  public void intakeIn() {
		talon1.set(-.9);
		talon2.set(.9);
  }
  
  public void intakeOut() {
		talon1.set(.4);
		talon2.set(-.4);
  }
  public void Outtakeslow () {
		talon1.set(-.4);
		talon2.set(.4);
  }
  public void intakeStop() {
    talon1.set(0);
    talon2.set(0);
  }
  

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
