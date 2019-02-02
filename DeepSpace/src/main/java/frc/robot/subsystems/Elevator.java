package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Elevator extends Subsystem {

	WPI_TalonSRX eL;
	WPI_TalonSRX eR;
	//DigitalInput top;
	//DigitalInput bottom;
	
	
	SpeedControllerGroup Up;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Elevator(int eLID, int eRID, int lMU, int lMD) {
    	
    	eL = new WPI_TalonSRX(eLID);
    	eR = new WPI_TalonSRX(eRID);
    	Up = new SpeedControllerGroup(eL, eR);
    	
    	eR.follow(eL);
    	
    	//top = new DigitalInput(lMU);
    	//bottom = new DigitalInput(lMD);
		// TODO Auto-generated constructor stub
	}

    
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void moveElevator(Joystick coDriver){
		
		Up.set(coDriver.getY());
		
	}
}

