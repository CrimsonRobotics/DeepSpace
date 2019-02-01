package frc.robot.subsystems;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ClimberUp;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Climber extends Subsystem {
	private WPI_TalonSRX climberBackRight;
	private WPI_TalonSRX climberBackLeft;
	private WPI_TalonSRX climberFrontRight;
	private WPI_TalonSRX climberFrontLeft;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int climbIDBL, int climbIDBR, int climbIDFL, int climbIDFR){
		climberBackRight = new WPI_TalonSRX(climbIDBR);
		climberBackLeft = new WPI_TalonSRX(climbIDBL);
		climberFrontRight = new WPI_TalonSRX(climbIDFR);
		climberFrontLeft = new WPI_TalonSRX(climbIDFL);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimberUp());
	}
	public void climb(){
		
			
		}
	}

