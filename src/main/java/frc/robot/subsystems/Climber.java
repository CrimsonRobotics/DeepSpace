package frc.robot.subsystems;



import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ClimberUp;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.management.CompilationMXBean;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class Climber extends Subsystem {
	public WPI_TalonSRX climberBackRight;
	public WPI_TalonSRX climberBackLeft;
	public WPI_TalonSRX climberFrontRight;
	public WPI_TalonSRX climberFrontLeft;
	//private Encoder EncoderCBR;
	//private double INPUT_Speed = .1;

	public Climber(int climbIDBL, int climbIDBR, int climbIDFL, int climbIDFR){
		climberBackRight = new WPI_TalonSRX(climbIDBR);
		climberBackLeft = new WPI_TalonSRX(climbIDBL);
		climberFrontRight = new WPI_TalonSRX(climbIDFR);
		climberFrontLeft = new WPI_TalonSRX(climbIDFL);
		//climberBackLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		//climberBackLeft.setSensorPhase(true);
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	public void ClimberUp(){
			
			climberBackLeft.set(-.2);
			climberBackRight.set(.2);
			climberFrontLeft.set(-.2);
			climberFrontRight.set(.2);
	
		}
	
	}

