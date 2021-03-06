package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.ClimberTestUp;
import frc.robot.commands.MiniWheelStop;
import frc.robot.commands.MiniWheels;

//unnecesary import

public class Climber extends Subsystem {
	public WPI_TalonSRX climberBackRight;
	public WPI_TalonSRX climberBackLeft;
	public WPI_TalonSRX climberFrontRight;
	public WPI_TalonSRX climberFrontLeft;
	public WPI_TalonSRX climbWheelL;
	public WPI_TalonSRX climbWheelR;
	public int EncPositionBL;
	public int EncPositionBR;
	public int EncPositionFL;
	public int EncPositionFR;
	public boolean LimPositionBL;
	public boolean LimPositionBR;
	public boolean LimPositionFL;
	public boolean LimPositionFR;
	public int whenStoppedBL;
	public int whenStoppedBR;
	public int whenStoppedFL;
	public int whenStoppedFR;
	public int Stop = 15000;
	public double speedbl = -.51;//-.31;
	public double speedbr = -.55;//-.35
	public double speedfr = -.73;//-.43
	public double speedfl = -.71;//-.41
	public double FrontDownSpeedFR = -.55;//-.32
	public double FrontDownSpeedFL = -.55;//-.27
	public double BackDownSpeedBR = -.55;//-.3
	public double BackDownSpeedBL = -.55;//-.34
	public double holdbl = -.13;
	public double holdbr = -.13;
	public double holdfl = -.23;
	public double holdfr = -.23;
	public double holdingfl = 0;
	public double holdingfr = 0;
	public double holdingbl = 0;
	public double holdingbr = 0; 
	public double wheelSpeed = .3;
	public boolean atRest = true;
	public boolean nextPositionBR = false;
	public boolean nextPositionBL = false;
	public boolean nextPositionFR = false;
	public boolean nextPositionFL = false;
	public int antiGravBL;
	public int antiGravBR;
	public int antiGravFL;
	public int antiGravFR;
	public int variability = 150;
	public boolean turnAntigravOn= true;
	public int isStopped=0;
	public boolean GRatedStop;
	public int levelThreeTarget = 27000;
	public int stepTarget;
	public int stepIncriment = 1800;
	public int softwareLimit = 1000;


	public Climber(int climbIDBL, int climbIDBR, int climbIDFL, int climbIDFR, int climbWheelLID, int climbWheelRID){
		climberBackRight = new WPI_TalonSRX(climbIDBR);
		climberBackLeft = new WPI_TalonSRX(climbIDBL);
		climberFrontRight = new WPI_TalonSRX(climbIDFR);
		climberFrontLeft = new WPI_TalonSRX(climbIDFL);
		climbWheelL = new WPI_TalonSRX(climbWheelLID);
		climbWheelR = new WPI_TalonSRX(climbWheelRID);

		//climberBackLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//climberBackLeft.setSensorPhase(true);
	}
	public void ClimberUp(Joystick CoDriver){
		turnAntigravOn= false;
		GRatedStop=true;
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();


		//while(EncPositionBL<500&&EncPositionBR<500&&EncPositionFL<500&&EncPositionFR<500){
		/*if(Math.abs(EncPositionBL)<Stop){
			climberBackLeft.set(-speed1);
		}
		else{
			climberBackLeft.set(holdbl);
		}

		if(Math.abs(EncPositionBR)<90 Stop){
			climberBackRight.set(spe09ed2);
		}09
		else{
			climberBackRight.set(holdbr);
		}

		if(Math.abs(EncPositionFL)<Stop){
			climberFrontLeft.set(speed4);
		}
		else{
			climberFrontLeft.set(holdfl);
		}

		if(Math.abs(EncPositionFR)<Stop){
			climberFrontRight.set(-speed3);
		}
		else{
			climberFrontRight.set(holdfr);
		}
		if(CoDriver.getX()>.2){
			Robot.arm.Arm.set(0);
			climbWheelR.set(wheelSpeed*CoDriver.getX()-.2);
			climbWheelL.set(wheelSpeed*CoDriver.getX()-.2);
		}		
		else{
			climbWheelL.set(0);
			climbWheelR.set(0) ;
		}
		*/
	//}
	climberFrontRight.set(-speedfr);
	climberFrontLeft.set(speedfl);
	climberBackRight.set(speedbr);
	climberBackLeft.set(-speedbl);
	}
	public void FrontDown(){
		turnAntigravOn= false;
		GRatedStop=true;
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		LimPositionFL= climberFrontLeft.getSensorCollection().isFwdLimitSwitchClosed();
		LimPositionFR= climberFrontRight.getSensorCollection().isFwdLimitSwitchClosed();
		climberFrontRight.set(speedfr);
		climberFrontLeft.set(-speedfl);
		climberBackLeft.set(-speedbl);
		climberBackRight.set(speedbr);
		/*if(LimPositionFR==true){
			climberFrontRight.set(holdingfr);
		}
		else{
			if(-EncPositionFR>0){
				climberFrontRight.set(speed3);
			}
			else{
				climberFrontRight.set(holdingfr);
			}
		}
		if(LimPositionFL==true){
			climberFrontLeft.set(holdingfl);
		}
		else{
			if(EncPositionFL>0){
				climberFrontLeft.set(-speed4);
			}
			else{
				climberFrontLeft.set(holdingfl);
			}
		}
		if(Math.abs(EncPositionBL)<Stop){
			climberBackLeft.set(-speed1);
		}
		else{
			climberBackLeft.set(holdbl);
		}

		if(Math.abs(EncPositionBR)<Stop){
			climberBackRight.set(speed2);
		}
		else{
			climberBackRight.set(holdbr);
		}*/
	}
	public void BackDown(){
		turnAntigravOn= false;
		GRatedStop=true;
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		LimPositionBL= climberBackLeft.getSensorCollection().isFwdLimitSwitchClosed();
		LimPositionBR= climberBackRight.getSensorCollection().isFwdLimitSwitchClosed();
		if(LimPositionBR==true){
			climberBackRight.set(holdingbr);
		}
		else{
			if(-EncPositionBR>0){
				climberBackRight.set(-speedbr);
			}
			else{
				climberBackRight.set(holdingbr);
			}
		}
		if(LimPositionBL==true){
			climberBackLeft.set(holdingbl);
		}
		else{
			if(EncPositionBL>0){
				climberBackLeft.set(speedbl);
			}
			else{
				climberBackLeft.set(holdingbl);
			}
		}
		
		
	}
	public void StopClimber(){
		if(GRatedStop){
		climberBackLeft.set(0);
		climberFrontLeft.set(0);
		climberBackRight.set(0);
		climberFrontRight.set(0);
		atRest=true;
		isStopped++;
		SmartDashboard.putNumber("isStopped",isStopped);
		GRatedStop=false;
		turnAntigravOn= true;
	}
		

	}
	public void MiniWheels(Joystick CoDriver){
	EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
	EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
	EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
	EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
	/*if(turnAntigravOn){
	if(atRest){
		whenStoppedBL=EncPositionBL;
		whenStoppedBR=EncPositionBR;
		whenStoppedFL=EncPositionFL;
		whenStoppedFR=EncPositionFR;
		atRest=false;
	}
	antiGravBL=whenStoppedBL-EncPositionBL;
	antiGravBR=whenStoppedBR-EncPositionBR;
	antiGravFL=whenStoppedFL-EncPositionFL;
	antiGravFR=whenStoppedFR-EncPositionFR;
	if(antiGravBL<variability&&antiGravBL>-variability){
		climberBackLeft.set(0);
	}
	if(antiGravBR<variability&&antiGravBR>-variability){
		climberBackRight.set(0);
	}
	if(antiGravFL<variability&&antiGravFL>-variability){
		climberFrontLeft.set(0);
	}
	if(antiGravFL<variability&&antiGravFL>-variability){
		climberFrontLeft.set(0);
	}
	if(antiGravBL>=variability){
		climberBackLeft.set(-.2);
	}
	if(antiGravBR>=variability){
		climberBackRight.set(-.2);
	}
	if(antiGravFL>=variability){
		climberFrontLeft.set(-.2);
	}
	if(antiGravFR>=variability){
		climberFrontRight.set(-.2);
	}
	if(antiGravBL<=-variability){
		climberBackLeft.set(.2);
	}
	if(antiGravBR<=-variability){
		climberBackRight.set(.2);
	}
	if(antiGravFL<=-variability){
		climberFrontLeft.set(.2);
	}
	if(antiGravFR<=-variability){
		climberFrontRight.set(.2);
	}
}*/
	SmartDashboard.putNumber("Antigrav climber",antiGravBL);
		
	}
	public void ClimberTestUp(){
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
		//if(EncPositionBL>levelThreeTarget||-EncPositionBR>levelThreeTarget||EncPositionFL>levelThreeTarget||-EncPositionFR>levelThreeTarget){
		if(nextPositionBL==false||nextPositionBR==false||nextPositionFL==false||nextPositionFR==false){
		if(-EncPositionBR<stepTarget){
			climberBackRight.set(speedbr);	
		}
		else{
			climberBackRight.set(holdbr);
			nextPositionBR=true;
		}
		if(EncPositionBL<stepTarget){
			climberBackLeft.set(-speedbl);	
		}
			else {
			climberBackLeft.set(-holdbl);
			nextPositionBL=true;
		}
		if(-EncPositionFR<stepTarget){
			climberFrontRight.set(-speedfr);	
		}
		else{
			climberFrontRight.set(-holdfr);
			nextPositionFR=true;
		}
		if(EncPositionFL<stepTarget){
			climberFrontLeft.set(speedfl);	
		}
		else{
			climberFrontLeft.set(holdfl);
			nextPositionFL=true;
		}
		}

		else{
			if(EncPositionBL<levelThreeTarget){
				stepTarget+=stepIncriment;
				nextPositionBL=false;
				nextPositionBR=false;
				nextPositionFL=false;
				nextPositionFR=false;
			}
		}
	}
		
	//}
	public void ClimberTestDown(){
		climberBackRight.set(-speedbr);
		climberBackLeft.set(speedbl);
		climberFrontLeft.set(-speedfl);
		climberFrontRight.set(speedfr);
	}
	public void ClimberTestHold(){
		climberBackRight.set(holdbr);
		climberBackLeft.set(-holdbl);
		climberFrontRight.set(-holdfr);
		climberFrontLeft.set(holdfl);
	}
	public void ClimberTestStop(){
		climberBackRight.set(0);
		climberBackLeft.set(0);
		climberFrontRight.set(0);
		climberFrontLeft.set(0);
	}	
	public void ClimberTestFrontUp(){
		climberFrontLeft.set(speedfl);
		climberFrontRight.set(-speedfr);
	}
	public void ClimberTestFrontDown(){
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
		if(EncPositionFL<softwareLimit){
			climberFrontLeft.set(0);
		}
		else{
		climberFrontLeft.set(-FrontDownSpeedFL);
		}
		if(-EncPositionFR<softwareLimit){
			climberFrontRight.set(0);
		}
		else{
		climberFrontRight.set(FrontDownSpeedFR);
		}
	}
	public void ClimberTestFrontStop(){
		climberFrontLeft.set(0);
		climberFrontRight.set(0);
	}
	public void ClimberTestBackUp(){
		climberBackLeft.set(speedbl);
		climberBackRight.set(-speedbr);
	}
	public void ClimberTestBackDown(){
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		if(EncPositionBL<softwareLimit){
			climberBackLeft.set(0);
		}
		else{
		climberBackLeft.set(BackDownSpeedBL);
		}
		if(-EncPositionBR<softwareLimit){
			climberBackRight.set(0);
		}
		else{
		climberBackRight.set(-BackDownSpeedBR);
		}
	}
	public void ClimberTestBackStop(){
		climberBackLeft.set(0);
		climberBackRight.set(0);
	}
	public void MiniWheelTest(){
		climbWheelL.set(-wheelSpeed);
		climbWheelR.set(wheelSpeed);
	}
	public void MiniWheelStopTest(){
		climbWheelL.set(0);
		climbWheelR.set(0);
	}
	public void MiniWheelReverseTest(){
		climbWheelL.set(wheelSpeed);
		climbWheelR.set(-wheelSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MiniWheels());
	}
}

