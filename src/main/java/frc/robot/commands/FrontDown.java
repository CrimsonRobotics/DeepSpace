package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.DigitalInput; 

/**
 *
 */
public class FrontDown extends Command {
	//WPI_TalonSRX Elevator1;
	//WPI_TalonSRX Elevator2;
	//DigitalInput limitSwitch;
    public FrontDown() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.m_subsystem);
        requires(Robot.m_subsystem);
        
       // WPI_TalonSRX(eL1).set(0.5); //?? 
       
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.climber.FrontDown();    	//while (limitSwitch.get()) {
            //Timer.delay(10);
            SmartDashboard.putNumber("Encoder Front Left", Robot.climber.climberFrontLeft.getSensorCollection().getQuadraturePosition());
            SmartDashboard.putNumber("Encoder Front Right", Robot.climber.climberFrontRight.getSensorCollection().getQuadraturePosition());
            SmartDashboard.putNumber("Encoder Back Left", Robot.climber.climberBackLeft.getSensorCollection().getQuadraturePosition());
            SmartDashboard.putNumber("Encoder Back Right", Robot.climber.climberBackRight.getSensorCollection().getQuadraturePosition());
            //SmartDashboard.putNumber("Encoder Back Right", Robot.climber.climberBackRight.getSensorCollection().getQuadraturePosition());
            
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