// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Timer;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.SpeakerTop;
import frc.robot.subsystems.AmpTop;
import frc.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Instance variables go here...
  SpeakerTop speaker = new SpeakerTop();  
  
  private Drivetrain m_drivetrain = new Drivetrain();
  private AmpTop m_ampTop = new AmpTop();

  private XboxController m_driverController = new XboxController(Constants.kDriverControllerPort);
  private XboxController m_operatorController = new XboxController(Constants.kOperatorControllerPort);
  private Timer m_timer = new Timer();
  
  @Override
  public void robotInit() {}
    

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_timer.start();
    m_timer.reset();
  }

  @Override
  public void autonomousPeriodic() {
    // Auto code goes here...
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if(m_operatorController.getRawButton(Constants.kShootButtonID)){
      speaker.shoot();
    }else{
      speaker.stop();
    }
    if(m_operatorController.getRawButton(Constants.kShootButtonId)){
      m_ampTop.shoot();
    }else{
      m_ampTop.stop();
    }
    m_drivetrain.drive(Constants.kMoveSpeed*m_driverController.getRawAxis(Constants.kDriverControllerForwardAxisId),
                       -Constants.kMoveSpeed*m_driverController.getRawAxis(Constants.kDriverControllerTurningAxisId));
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}

}
