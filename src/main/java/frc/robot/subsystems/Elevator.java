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
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

/**
 *
 */
public class Elevator extends Subsystem {

	WPI_TalonSRX Elevator1;
	WPI_TalonSRX Elevator2;
	DigitalInput topElevator;
	DigitalInput bottomElevator;
	DigitalInput nnewl;

	double elevatorTopPosition = 1000; // change ticks accordingly
	double slowDownArea = 600; //change ticks accordingly

	double antiGrav = .08;


	//
	public Elevator(int intake1, int intake2, int lmB, int lmT) {
    	//Elevator1 = new WPI_TalonSRX(el1);
    	//Elevator2 = new WPI_TalonSRX(el2);
		   topElevator = new DigitalInput(1);
		   bottomElevator = new DigitalInput(0);
		   Elevator1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
		   Elevator2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
		   Elevator1.setSensorPhase(true);
		   Elevator2.setSensorPhase(true);
		   
	
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ElevatorControl());
    	
    }

    public void moveElevator(Joystick coStick) {
		//if(Math.abs(elevatorTopPosition-Elevator1.getSelectedSensorPostition(0))<slowDownArea){


		}

        //Elevator1.set(coStick.getY());
        //Elevator2.set(coStick.getY());

    }
   
