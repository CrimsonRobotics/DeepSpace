package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ClawIn;

//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.DigitalInput; 

/**
 *
 */
public class HatchSequentialDeliver extends CommandGroup {
	//WPI_TalonSRX Elevator1;
	//WPI_TalonSRX Elevator2;
	//DigitalInput limitSwitch;
    public HatchSequentialDeliver() {
        //setInterruptible(true);
        //addSequential(new ClawOut());
        addSequential(new CenterOut());
        addSequential(new WaitCommand(1));
        addSequential(new ClawIn());
        addSequential(new WaitCommand(.25));
        addSequential(new CenterIn());
        addSequential(new WaitCommand(.5));
        addSequential(new ClawOut()); 
        //addSequential(new CenterIn());
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.m_subsystem);
        //requires(Robot.arm);
        
       // WPI_TalonSRX(eL1).set(0.5); 
       
   
    }

    // Called just before this Command runs the first time
   /* protected void initialize() {
     	
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Robot.hatchintake.ClawIn(); 
       
        //while (limitSwitch.get()) {
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
    }*/
}