package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.MiniWheels;



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
	public double speed1 = -.3;
	public double speed2 = -.3;
	public double speed3 = -.33;
	public double speed4 = -.4;
	public double wheelSpeed = .5;
	public boolean atRest = true;
	public int antiGravBL;
	public int antiGravBR;
	public int antiGravFL;
	public int antiGravFR;
	public int variability = 150;
	public boolean turnAntigravOn= true;
	public int isStopped=0;
	public boolean GRatedStop;


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
		if(Math.abs(EncPositionBL)<Stop){
			climberBackLeft.set(-speed1);
		}
		else{
			climberBackLeft.set(0);
		}

		if(Math.abs(EncPositionBR)<Stop){
			climberBackRight.set(speed2);
		}
		else{
			climberBackRight.set(0);
		}

		if(Math.abs(EncPositionFL)<Stop){
			climberFrontLeft.set(speed4);
		}
		else{
			climberFrontLeft.set(0);
		}

		if(Math.abs(EncPositionFR)<Stop){
			climberFrontRight.set(-speed3);
		}
		else{
			climberFrontRight.set(0);
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
	//}
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

		if(LimPositionFR==true){
			climberFrontRight.set(0);
		}
		else{
			if(-EncPositionFR>0){
				climberFrontRight.set(speed3);
			}
			else{
				climberFrontRight.set(0);
			}
		}
		if(LimPositionFL==true){
			climberFrontLeft.set(0);
		}
		else{
			if(EncPositionFL>0){
				climberFrontLeft.set(-speed4);
			}
			else{
				climberFrontLeft.set(0);
			}
		}
		if(Math.abs(EncPositionBL)<Stop){
			climberBackLeft.set(-speed1);
		}
		else{
			climberBackLeft.set(0);
		}

		if(Math.abs(EncPositionBR)<Stop){
			climberBackRight.set(speed2);
		}
		else{
			climberBackRight.set(0);
		}
	}
	public void BackDown(){
		turnAntigravOn= false;
		GRatedStop=true;
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		LimPositionBL= climberBackLeft.getSensorCollection().isFwdLimitSwitchClosed();
		LimPositionBR= climberBackRight.getSensorCollection().isFwdLimitSwitchClosed();
		if(LimPositionBR==true){
			climberBackRight.set(0);
		}
		else{
			if(-EncPositionBR>0){
				climberBackRight.set(-speed2);
			}
			else{
				climberBackRight.set(0);
			}
		}
		if(LimPositionBL==true){
			climberBackLeft.set(0);
		}
		else{
			if(EncPositionBL>0){
				climberBackLeft.set(speed1);
			}
			else{
				climberBackLeft.set(0);
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
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MiniWheels());
	}
}

