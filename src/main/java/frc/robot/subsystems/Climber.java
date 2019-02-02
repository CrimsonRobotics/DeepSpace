package frc.robot.subsystems;



import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
	AnalogInput EncCBR;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int climbIDBL, int climbIDBR, int climbIDFL, int climbIDFR){
		climberBackRight = new WPI_TalonSRX(climbIDBR);
		climberBackLeft = new WPI_TalonSRX(climbIDBL);
		climberFrontRight = new WPI_TalonSRX(climbIDFR);
		climberFrontLeft = new WPI_TalonSRX(climbIDFL);
		EncCBR = new AnalogInput(1);
	}
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new ClimberUp());
	}
	public void ClimberUp(){
		while(EncCBR.getValue()>2){
			climberBackLeft.set(.1);
		climberFrontLeft.set(.1);
		//opposite direction as other two
		climberFrontRight.set(-.1);
		climberBackRight.set(-.1);
			}
		}
	}

