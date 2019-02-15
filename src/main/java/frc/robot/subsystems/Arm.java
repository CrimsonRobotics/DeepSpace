package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArmWork;



public class Arm extends Subsystem {
	public WPI_TalonSRX Arm;
	public int EncPosition;
	public int max=10000-438;
	public int min=438;
	public int whenStopped;
	public int Antigrav; 
	public boolean atRest;

	public Arm(int armID){
		Arm = new WPI_TalonSRX(armID);
	}
	public void ArmWork(Joystick Driver){
		EncPosition = Arm.getSensorCollection().getQuadraturePosition();

		if(Driver.getY()<.1&&Driver.getY()>-.1){
			if(atRest==false){
				whenStopped=EncPosition;
				atRest=true;
			}
			Antigrav=whenStopped-EncPosition;
			if(Antigrav>500){
				Arm.set(-.2);
			}
			if(Antigrav<-500){
				Arm.set(.2);
			}
			if(Antigrav>=-500&&Antigrav<=500){
				Arm.set(0);
			}
			SmartDashboard.putNumber("Antigrav value", Antigrav);
		}
		else{
		if(EncPosition>=min ){
			if(EncPosition<=max){
				Arm.set((-.4*Driver.getY())+.05);
				atRest=false;
			}
			else{
				if(Driver.getY()<0){
					Arm.set(-.4*Driver.getY());
					atRest=false;
				}
				else{
					Arm.set(0); 
				}
			}
		}
		else{
			if(Driver.getY()>0){
				Arm.set(-.4*Driver.getY());
				atRest=false;
			}
		else{
			Arm.set(0);
		}
	}
	} 
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmWork());
	}
	
	}

