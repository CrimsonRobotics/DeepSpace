package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;



public class HatchIntake extends Subsystem {
	public DoubleSolenoid GrabberS;
	//public Solenoid ClawS;
	public Solenoid DropperS;
//	public DoubleSolenoid CenterS;
	public boolean toggleGrab = true;
	public boolean toggleCenter = true;
	//private Encoder EncoderCBR;
	//private double INPUT_Speed = .1;

	public HatchIntake(int DropperID,int GrabberID, int GrabberID2){
		//ClawS = new Solenoid(ClawID);
		DropperS = new Solenoid(DropperID);
		GrabberS = new DoubleSolenoid(GrabberID, GrabberID2);
		//CenterS = new DoubleSolenoid(CenterID, CenterID2);
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	public void ClawIn(){
	//	ClawS.set(true);
	}
	public void ClawOut(){
	//	ClawS.set(false);
	}
	public void Drop(){
		DropperS.set(true);
	}
	public void DropperUp(){
		DropperS.set(false);
	}
	public void Grab(){
		if(toggleGrab){
			GrabberS.set(Value.kForward);
			toggleGrab=false;
		}
		if(toggleGrab==false){
			GrabberS.set(Value.kReverse);
			toggleGrab=true;
		}
	}
	public void CenterOut(){
		if(toggleCenter){
		//	CenterS.set(Value.kForward);
			toggleCenter=false;
		}
		if(toggleCenter==false){
		//	CenterS.set(Value.kReverse);
			toggleCenter=true;
		}
	}
	
	}

