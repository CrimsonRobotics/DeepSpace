/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
//import edu.wpi.first.wpilibj.IterativeRobot;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public double antiGravClimber = .05;
  public static OI m_oi;
  public static final Intake intake = new Intake(RobotMap.intake1, RobotMap.intake2);
  public static final Arm arm = new Arm(RobotMap.mod2, RobotMap.arm, RobotMap.ArmShifter, RobotMap.ArmShifter2);
 
  public static final Climber climber = new Climber(RobotMap.climberBackLeft,RobotMap.climberBackRight, RobotMap.climberFrontLeft, RobotMap.climberFrontRight, RobotMap.climberWheelL, RobotMap.climberWheelR); 
  public static final HatchIntake hatchintake = new HatchIntake(RobotMap.mod, RobotMap.mod2,RobotMap.centerS, RobotMap.centerS2, RobotMap.clawS1, RobotMap.clawS2);
  public static final DriveTrain driveTrain = new DriveTrain(RobotMap.DT_FRONTLEFT, RobotMap.DT_BACKLEFT, RobotMap.DT_FRONTRIGHT, RobotMap.DT_BACKRIGHT, RobotMap.Shifty, RobotMap.Shifty2, RobotMap.mod, RobotMap.mod2);
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    System.out.println("running");
    new Thread(() -> {
      //UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
      //UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture();

      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
      UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(1);
      // might have to drop resolution further during competition
      camera.setFPS(15);
      camera1.setFPS(15);

      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 320, 240);
      
      
      Mat source = new Mat();
      Mat output = new Mat();
      
      while(!Thread.interrupted()) {
          cvSink.grabFrame(source);
          Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
          outputStream.putFrame(output);
      }
  }).start();
    
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /** b
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
   /* Robot.climber.climberFrontRight.set(antiGravClimber);
    Robot.climber.climberFrontLeft.set(antiGravClimber);
    Robot.climber.climberBackLeft.set(antiGravClimber);
    Robot.climber.climberBackRight.set(antiGravClimber);*/
    Robot.climber.climberFrontRight.setSelectedSensorPosition(0);
    Robot.climber.climberFrontLeft.setSelectedSensorPosition(0);
    Robot.climber.climberBackLeft.setSelectedSensorPosition(0);
    Robot.climber.climberBackRight.setSelectedSensorPosition(0);
    Robot.arm.Arm.setSelectedSensorPosition(0);
    Robot.arm.whenStopped=0;
    Robot.climber.whenStoppedBL=0;
    Robot.climber.whenStoppedBR=0;
    Robot.climber.whenStoppedFL=0;
    Robot.climber.whenStoppedFR=0;
    Robot.climber.climberFrontRight.set(0);
    Robot.climber.climberFrontLeft.set(0);
    Robot.climber.climberBackLeft.set(0);
    Robot.climber.climberBackRight.set(0);
    Robot.climber.climbWheelL.set(0);
    Robot.climber.climbWheelR.set(0);
    Robot.climber.stepTarget = Robot.climber.stepIncriment;


    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
