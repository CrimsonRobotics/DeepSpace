package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.commands.ClimberUp;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.management.CompilationMXBean;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


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
	public int whenStopped;
	public int Stop = 500;
	public double speed = .4;

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

<<<<<<< HEAD
			 
			climberBackLeft.set(.2);
			climberBackRight.set(-.2);
			climberFrontLeft.set(.2);
			climberFrontRight.set(-.2);
			System.out.println("running");
	//Timer.delay(10);
	

		climberBackLeft.set(.1);
		climberFrontLeft.set(.1);
		//opposite direction as other two
		climberFrontRight.set(-.1);
		climberBackRight.set(-.1);
=======
		if(EncPositionBR<Stop){
			climberBackRight.set(speed);
		}
		else{
			climberBackRight.set(0);
		}
>>>>>>> 94cac2e7f9284a2401a0908f3c7c4c1cebcb9ef4

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
		EncPositionFL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionFR = climberBackRight.getSensorCollection().getQuadraturePosition();
		if(EncPositionFL>0){
			climberFrontLeft.set(speed);
		}
		else{
			climberFrontLeft.set(0);
		}
		if(EncPositionFR>0){
			climberFrontRight.set(speed);
		}
		else{
			climberFrontRight.set(0);
		}
	}
	public void BackDown(){
		EncPositionBL = climberBackLeft.getSensorCollection().getQuadraturePosition();
		EncPositionBR = climberBackRight.getSensorCollection().getQuadraturePosition();
		if(EncPositionBL>0){
			climberBackLeft.set(speed);
		}
		else{
			climberBackLeft.set(0);
		}
		if(EncPositionBR>0){
			climberBackRight.set(speed);
		}
		else{
			climberBackRight.set(0);
		}
	}
	public void MiniWheels(Joystick CoDriver){
		if(CoDriver.getX()>.2){
			Robot.arm.Arm.set(0);
			climbWheelR.set(CoDriver.getX());
			climbWheelL.set(CoDriver.getX());
		}		
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
}

