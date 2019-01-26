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
	private WPI_TalonSRX climber;
	private final double INPUT_MULTIPLIER = 1;

	public Climber(int climbID){
		climber = new WPI_TalonSRX(climbID);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimberUp());
	}
	public void climb(Joystick coStick){
    
            climber.set(coStick.getX());
	}
}
