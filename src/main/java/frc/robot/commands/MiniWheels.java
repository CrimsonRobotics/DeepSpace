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
public class MiniWheels extends Command {
	//WPI_TalonSRX Elevator1;
	//WPI_TalonSRX Elevator2;
	//DigitalInput limitSwitch;
    public MiniWheels() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.m_subsystem);
        requires(Robot.climber);
        
       // WPI_TalonSRX(eL1).set(0.5); //?? 
       
   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.climber.MiniWheels(Robot.m_oi.getcoDriver()); 
        SmartDashboard.putNumber("Speed Front Left", Robot.climber.climberFrontLeft.get());
        SmartDashboard.putNumber("Speed Front Right", Robot.climber.climberFrontRight.get());
        SmartDashboard.putNumber("Speed Back Left", Robot.climber.climberBackLeft.get());
        SmartDashboard.putNumber("Speed Back Right", Robot.climber.climberBackRight.get());
        
        SmartDashboard.putNumber("Encoder Front Left", Robot.climber.climberFrontLeft.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Encoder Front Right", Robot.climber.climberFrontRight.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Encoder Back Left", Robot.climber.climberBackLeft.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Encoder Back Right", Robot.climber.climberBackRight.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Mini Wheel", Robot.climber.climbWheelL.get());
        SmartDashboard.putNumber("Mini Wheel 2", Robot.climber.climbWheelR.get());   
        
        SmartDashboard.putBoolean("@target Front Left", Robot.climber.nextPositionFL);
        SmartDashboard.putBoolean("@target Front Right", Robot.climber.nextPositionFR);
        SmartDashboard.putBoolean("@target Back Left", Robot.climber.nextPositionBL);
        SmartDashboard.putBoolean("@target Back Right", Robot.climber.nextPositionBR);
        SmartDashboard.putNumber("Final Target", Robot.climber.levelThreeTarget);
        SmartDashboard.putNumber("Current Target", Robot.climber.stepTarget);
        
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