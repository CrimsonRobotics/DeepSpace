package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ArmWork;



public class Arm extends Subsystem {
	public WPI_TalonSRX Arm;

	public Arm(int armID){
		Arm = new WPI_TalonSRX(armID);
	}
	public void ArmWork(Joystick Driver){
		Arm.set((.4*Driver.getY())+.05);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmWork());
	}
	
	}

