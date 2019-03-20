package frc.robot.commands;
<<<<<<< Updated upstream:src/main/java/frc/robot/commands/Grab.java

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
//import edu.wpi.first.wpilibj.PWMTalonSRX;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
>>>>>>> Stashed changes:src/main/java/frc/robot/commands/ElevatorControl.java

//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.DigitalInput; 

/**
 *
 */
public class Grab extends Command {
	//WPI_TalonSRX Elevator1;
	//WPI_TalonSRX Elevator2;
	//DigitalInput limitSwitch;
    public Grab() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.m_subsystem);
        requires(Robot.hatchintake);
        
       // WPI_TalonSRX(eL1).set(0.5); //?? 
       
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.hatchintake.Grab();    	//while (limitSwitch.get()) {
            //Timer.delay(10);
            }
    	
  
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}