package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ArmWork;



public class Arm extends Subsystem {
	public WPI_TalonSRX Arm;
	public int EncPosition;
	public int max=3920;
	public int min=100;
	public int variability=100;
	public int whenStopped;
	public int Antigrav; 
	public boolean atRest;
	public DoubleSolenoid shifter;
	public boolean shiftToggle=false;

	public Arm(int mod2, int armID, int shiftID, int shiftID2){
		Arm = new WPI_TalonSRX(armID);
		shifter = new DoubleSolenoid(mod2,shiftID,shiftID2);
	}
	public void ArmWork(Joystick Driver){
		EncPosition = Arm.getSensorCollection().getQuadraturePosition();

		if(Driver.getY()<.1&&Driver.getY()>-.1){
			if(atRest==false){
				whenStopped=EncPosition;
				atRest=true;
			}
			Antigrav=whenStopped-EncPosition;
			if(Antigrav>variability){
				Arm.set(-.2);
			}
			if(Antigrav<-variability){
				Arm.set(.2);
			}
			if(Antigrav>=-variability&&Antigrav<=variability){
				Arm.set(0);
			}
			SmartDashboard.putNumber("Antigrav value", Antigrav);
		}
		else{
		if(EncPosition>=min ){
			if(EncPosition<=max){
				Arm.set(.4*Driver.getY());
				atRest=false;
			}
			else{
				if(Driver.getY()>0){
					Arm.set(.4*Driver.getY());
					atRest=false;
				}
				else{
					Arm.set(.2); 
				}
			}
		}
		else{
			if(Driver.getY()<0){
				Arm.set(.4*Driver.getY());
				atRest=false;
			}
		else{
			Arm.set(.2);
		}
	}
	}
}
	public void ArmShift(){
		if(shiftToggle){
			shifter.set(Value.kReverse);
			shiftToggle=false;
		}
		else if(shiftToggle==false ){
			shifter.set(Value.kForward);
			shiftToggle=true;
		}
	} 
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmWork());
	}
	
	}

