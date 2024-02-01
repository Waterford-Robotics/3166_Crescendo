package frc.robot.subsystems;

//import java.util.Timer;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The robot's drivetrain.
 */
public final class Drivetrain {
  
  
  private Talon m_right1 = new Talon(0);
  private Talon m_right2 = new Talon(1);
  private Talon m_left1 = new Talon(2);
  private Talon m_left2 = new Talon(3);
  public MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_right1, m_right2);
  private MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_left1, m_left2);
  public DifferentialDrive m_DifferentialDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  



}


  // Methods go here...
