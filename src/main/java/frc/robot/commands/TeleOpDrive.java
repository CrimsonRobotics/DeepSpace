package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleOpDrive extends Command {

    public TeleOpDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.driveTrain); //do execute the command, this calls the newly made drivetrain from talons
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.TeleOpCraneDrive(Robot.m_oi.getDriverLeft(), Robot.m_oi.getDriverRight());
       // SmartDashboard.putNumber("Encoder Front Left", Robot.driveTrain.fL.getSensorCollection().getQuadraturePosition());
       // SmartDashboard.putNumber("Encoder Front Right", Robot.driveTrain.fR.getSensorCollection().getQuadraturePosition());
       // SmartDashboard.putNumber("Encoder Back Left", Robot.driveTrain.bL.getSensorCollection().getQuadraturePosition());
       // SmartDashboard.putNumber("Encoder Back Right", Robot.driveTrain.bR.getSensorCollection().getQuadraturePosition());
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
