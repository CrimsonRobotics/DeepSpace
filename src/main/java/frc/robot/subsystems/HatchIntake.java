package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;



public class HatchIntake extends Subsystem {
	public DoubleSolenoid GrabberS1;
	public DoubleSolenoid GrabberS2;
	public Solenoid ClawS;
	public DoubleSolenoid DropperS1;
	public DoubleSolenoid DropperS2;
	public DoubleSolenoid DropperS3;
	public Solenoid CenterS;
	public boolean toggleGrab = true;
	//private Encoder EncoderCBR;
	//private double INPUT_Speed = .1;

	public HatchIntake(int mod,int Dropper1,int Dropper2,int Dropper3,int Dropper4,int Dropper5,int Dropper6,int GrabberID, int GrabberID2,int GrabberID3, int GrabberID4, int Center, int Claw){
		//Remember to do the module aswell!
		
		ClawS = new Solenoid(mod, Claw);
		DropperS1 = new DoubleSolenoid(mod,Dropper1,Dropper2);
		DropperS2 = new DoubleSolenoid(mod, Dropper3, Dropper4);
		DropperS3 = new DoubleSolenoid(mod, Dropper5, Dropper6);
		GrabberS1 = new DoubleSolenoid(GrabberID, GrabberID2);
		GrabberS2 = new DoubleSolenoid(mod,GrabberID3,GrabberID4);
		CenterS= new Solenoid(mod, Center);
		
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	public void ClawIn(){
		ClawS.set(true);
	}
	public void ClawOut(){
		ClawS.set(false);
	}
	public void Drop(){
		DropperS1.set(Value.kForward);
		DropperS2.set(Value.kForward);
		DropperS3.set(Value.kForward);
	}
	public void DropperUp(){
		DropperS1.set(Value.kReverse);
		DropperS2.set(Value.kReverse);
		DropperS3.set(Value.kReverse);
	}
	public void Grab(){
		if(toggleGrab){
			GrabberS1.set(Value.kForward);
			GrabberS2.set(Value.kForward);
			toggleGrab=false;
		}
		if(toggleGrab==false){
			GrabberS1.set(Value.kReverse);
			GrabberS2.set(Value.kReverse);
			toggleGrab=true;
		}
	}
	public void CenterOut(){
			CenterS.set(true);
		}
	public void CenterIn(){
			CenterS.set(false);
			
		}
	
	
	}

