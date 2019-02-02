package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	public WPI_TalonSRX sL;
	public WPI_TalonSRX sR;
	
	SpeedControllerGroup turret;
	


	public Shooter(int sLID, int sRID){
		
		sL = new WPI_TalonSRX(sLID);
		sR = new WPI_TalonSRX(sLID);
		turret = new SpeedControllerGroup(sL, sR);
		sR.follow(sL);
		
	}
	
	public void ShootOut(){
		
		turret.set(1);
	}
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

