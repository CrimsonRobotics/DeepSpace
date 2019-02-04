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
	private WPI_TalonSRX climberBackRight;
	private WPI_TalonSRX climberBackLeft;
	private WPI_TalonSRX climberFrontRight;
	private WPI_TalonSRX climberFrontLeft;
	//private Encoder EncoderCBR;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int climbIDBL, int climbIDBR, int climbIDFL, int climbIDFR){
		climberBackRight = new WPI_TalonSRX(climbIDBR);
		climberBackLeft = new WPI_TalonSRX(climbIDBL);
		climberFrontRight = new WPI_TalonSRX(climbIDFR);
		climberFrontLeft = new WPI_TalonSRX(climbIDFL);
		climberBackLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		climberBackLeft.setSensorPhase(true);
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	public void ClimberUp(){
		if(climberBackLeft.getSelectedSensorPosition()<500){
			climberBackLeft.set(-.5);

			}
		else{
			climberBackLeft.set(0);
			climberFrontLeft.set(0);
		//opposite direction as other two
			climberFrontRight.set(0);
			climberBackRight.set(0);
		}
		}
	}

