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
	public int whenStopped;
	public int Stop = 5000;
	public double speed = -.4;
	public double wheelSpeed = .5;

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
	public void ClimberUp(){
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
		//while(EncPositionBL<500&&EncPositionBR<500&&EncPositionFL<500&&EncPositionFR<500){
		if(EncPositionBL<Stop){
			climberBackLeft.set(speed);
		}
		else{
			climberBackLeft.set(0);
		}

		if(EncPositionBR<Stop){
			climberBackRight.set(speed);
		}
		else{
			climberBackRight.set(0);
		}

		if(EncPositionFL<Stop){
			climberFrontLeft.set(speed);
		}
		else{
			climberFrontLeft.set(0);
		}

		if(EncPositionFR<Stop){
			climberFrontRight.set(speed);
		}
		else{
			climberFrontRight.set(0);
		}
	//}
	}
	public void FrontDown(){
		EncPositionFL = climberFrontLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberFrontRight.getSensorCollection().getQuadraturePosition();
		LimPositionFL= climberFrontLeft.getSensorCollection().isFwdLimitSwitchClosed();
		LimPositionFR= climberFrontRight.getSensorCollection().isFwdLimitSwitchClosed();

		if(LimPositionFR==false){
			climberFrontRight.set(0);
		}
		else{
			if(EncPositionFR>0){
				climberFrontRight.set(-speed);
			}
			else{
				climberFrontRight.set(0);
			}
		}
		if(LimPositionFL==false){
			climberFrontLeft.set(0);
		}
		else{
			if(EncPositionFL>0){
				climberFrontLeft.set(-speed);
			}
			else{
				climberFrontLeft.set(0);
			}
		}
	}
	public void BackDown(){
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		LimPositionBL= climberBackLeft.getSensorCollection().isFwdLimitSwitchClosed();
		LimPositionBR= climberBackRight.getSensorCollection().isFwdLimitSwitchClosed();
		if(LimPositionBR==false){
			climberBackRight.set(0);
		}
		else{
			if(EncPositionBR>0){
				climberBackRight.set(-speed);
			}
			else{
				climberBackRight.set(0);
			}
		}
		if(LimPositionBL==false){
			climberBackLeft.set(0);
		}
		else{
			if(EncPositionBL>0){
				climberBackLeft.set(-speed);
			}
			else{
				climberBackLeft.set(0);
			}
		}
		
		
	}
	public void StopClimber(){
		climberBackLeft.set(0);
		climberFrontLeft.set(0);
		climberBackRight.set(0);
		climberFrontRight.set(0);

	}
	public void MiniWheels(Joystick CoDriver){

		if(CoDriver.getX()>.2){
			Robot.arm.Arm.set(0);
			climbWheelR.set(wheelSpeed*CoDriver.getX()-.2);
			climbWheelL.set(wheelSpeed*CoDriver.getX()-.2);
		}		
		else{
			climbWheelL.set(0);
			climbWheelR.set(0) ;
		}
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MiniWheels());
	}
}

