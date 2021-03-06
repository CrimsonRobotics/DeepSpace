package frc.robot.subsystems;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.commands.TeleOpDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public WPI_TalonSRX fL;
	public WPI_TalonSRX bL;
	public WPI_TalonSRX fR;
	public WPI_TalonSRX bR;
	public Solenoid Shifty;
	public Solenoid Shifty2;
	//public Solenoid notShifty;
	//Talons are defined
	
	DifferentialDrive drive; 
	//RobotDrive instance to control motors during teleop
	
	SpeedControllerGroup leftDrive;
	SpeedControllerGroup rightDrive;
	//This is how the motors are linked because the right and left sides have to work together
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public DriveTrain(int fLID, int bLID, int fRID, int bRID, int Shiftyid, int Shifty2id, int mod, int mod2){ 
	
		//this method was pulled from Robot.java and is how everything connects 
		
		fL = new WPI_TalonSRX(fLID);
		bL = new WPI_TalonSRX(bLID);
		fR = new WPI_TalonSRX(fRID);
		bR = new WPI_TalonSRX(bRID);
		Shifty = new Solenoid(mod, Shiftyid);
		Shifty2 = new Solenoid(mod2,Shifty2id);
		//notShifty = new Solenoid(0);
		//bL.setSensorPhase(true);
		//talons are connected to actual IDs via the constructor
		
		leftDrive = new SpeedControllerGroup(fL, bL);
	    rightDrive = new SpeedControllerGroup(fR, bR);
	    
	    //defines what is with what
	    
	    bL.follow(fL);//fL leads bL follows
		bR.follow(fR);//fR leads bR follows
	
		drive = new DifferentialDrive(this.leftDrive, this.rightDrive);
	    
		
		bL.setInverted(false);
		bR.setInverted(false);
		fL.setInverted(false);
		fR.setInverted(false);
		
		//Drivetrain is made
	}
	
	public void TeleOpCraneDrive(Joystick left, Joystick right){
		
		 drive.arcadeDrive(left.getY(), -right.getX(), true);
		 SmartDashboard.putBoolean("Shift status", Robot.m_oi.getDriverLeft().getRawButton(1));
		
	}
	public void Shift(){
		Shifty.set(true);
		Shifty2.set(true);
	} 
	public void Unshift(){
		Shifty.set(false);
		Shifty2.set(false);
	}
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TeleOpDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

