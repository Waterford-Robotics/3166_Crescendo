// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Timer;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private XboxController drivController = new XboxController(0);
  private Drivetrain drivetrain = new Drivetrain();
  private Timer m_Timer = new Timer();





  // Instance variables go here...
  
  @Override
  public void robotInit() {}
    

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

    m_Timer.start();
    m_Timer.reset();


  }

  @Override
  public void autonomousPeriodic(){
    
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drivetrain.drive(Constants.kMoveSpeed*drivController.getRawAxis(1), -Constants.kMoveSpeed*drivController.getRawAxis(4));
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
