package frc.robot.subsystems;

//import java.util.Timer;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

/**
 * The robot's drivetrain.
 */
public final class Drivetrain {
  
  
  private Talon m_right1 = new Talon(Constants.kRight1DriveMotorId);
  private Talon m_right2 = new Talon(Constants.kRight2DriveMotorId);
  private Talon m_left1 = new Talon(Constants.kLeft1DriveMotorId);
  private Talon m_left2 = new Talon(Constants.kLeft2DriveMotorId);
  private MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_right1, m_right2);
  private MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_left1, m_left2);
  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  public Drivetrain() {
    m_rightMotors.setInverted(true);
  }

  public void drive(double forwardSpeed, double turningSpeed) {
    m_differentialDrive.arcadeDrive(forwardSpeed, turningSpeed);
  }

  public void stop() {
    m_differentialDrive.arcadeDrive(0, 0);

  }
}

  
