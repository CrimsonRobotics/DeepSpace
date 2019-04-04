package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;



public class HatchIntake extends Subsystem {
	//public DoubleSolenoid GrabberS1;
	//public DoubleSolenoid GrabberS2;
	public DoubleSolenoid ClawS;
	//public DoubleSolenoid DropperS1;
	//public DoubleSolenoid DropperS2;
	//public DoubleSolenoid DropperS3;
	public DoubleSolenoid CenterS;
	public boolean toggleGrab = true;
	public boolean toggleCenter = true;
	//private Encoder EncoderCBR;
	//private double INPUT_Speed = .1;

	public HatchIntake(int mod,int mod2, int Center, int Center2, int Claw1, int Claw2){
		//Remember to do the module aswell!
		
		ClawS = new DoubleSolenoid(mod, Claw1, Claw2);
		//DropperS1 = new DoubleSolenoid(mod2,Dropper1,Dropper2);
		//DropperS2 = new DoubleSolenoid(mod, Dropper3, Dropper4);
		//DropperS3 = new DoubleSolenoid(mod, Dropper5, Dropper6);
		//GrabberS1 = new DoubleSolenoid(mod2,GrabberID, GrabberID2);
		//GrabberS2 = new DoubleSolenoid(mod2,GrabberID3,GrabberID4);
		CenterS= new DoubleSolenoid(mod2, Center, Center2);
		
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	
	public void ClawIn(){
		ClawS.set(Value.kForward);
	}
	public void ClawOut(){
		ClawS.set(Value.kReverse);
	}
	public void Drop(){
		//DropperS1.set(Value.kForward);
		//DropperS2.set(Value.kForward);
		//DropperS3.set(Value.kForward);
	}
	public void DropperUp(){
		//DropperS1.set(Value.kReverse);
		//DropperS2.set(Value.kReverse);
		//DropperS3.set(Value.kReverse);
	}
	public void Grab(){
		if(toggleGrab){
		//	GrabberS1.set(Value.kForward);
		//	GrabberS2.set(Value.kForward);
			toggleGrab=false;
		}
		if(toggleGrab==false){
		//	GrabberS1.set(Value.kReverse);
		//	GrabberS2.set(Value.kReverse);
			toggleGrab=true;
		}
	}
	public void CenterOut(){
	
			CenterS.set(Value.kForward);
			toggleCenter=false;
	}

		public void CenterIn(){
		CenterS.set(Value.kReverse);
	

		}
	}
	


