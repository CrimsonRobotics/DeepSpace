package frc.robot.subsystems;

<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

=======

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorControl;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
>>>>>>> 83372347a4539a25f6cc31e5dff3471897fe9e90

/**
 *
 */
public class Elevator extends Subsystem {

<<<<<<< HEAD
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

=======
	WPI_TalonSRX Elevator1;
	WPI_TalonSRX Elevator2;
	DigitalInput topElevator;
	DigitalInput bottomElevator;
	DigitalInput nnewl;
	
	//
	public Elevator(int el1, int el2, int lmB, int lmT) {
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
>>>>>>> 83372347a4539a25f6cc31e5dff3471897fe9e90
