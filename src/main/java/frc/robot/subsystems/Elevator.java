package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorControl;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	WPI_TalonSRX Elevator1;
	WPI_TalonSRX Elevator2;
	DigitalInput topElevator;
	DigitalInput bottomElevator;
	DigitalInput nnewl;
	
	//
	public Elevator(int intake1, int intake2 z26		, int lmB, int lmT) {
    	Elevator1 = new WPI_TalonSRX(el1);
    	Elevator2 = new WPI_TalonSRX(el2);
	   	topElevator = new DigitalInput(1);
	   	bottomElevator = new DigitalInput(0);
	
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorControl());
    	
    }

    public void moveElevator(Joystick coStick) {

        Elevator1.set(coStick.getY());
        Elevator2.set(coStick.getY());

    }
}    