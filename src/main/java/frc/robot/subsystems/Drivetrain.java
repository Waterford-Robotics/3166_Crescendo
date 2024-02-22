package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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
  
  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_left1::set, m_right1::set);

  public Drivetrain() {
    m_right1.setInverted(true);
    m_right1.addFollower(m_right2);

    m_left1.addFollower(m_left2);
  }

  public void drive(double forwardSpeed, double turningSpeed) {
    m_differentialDrive.arcadeDrive(forwardSpeed, turningSpeed);
  }

  public void stop() {
    m_differentialDrive.arcadeDrive(0, 0);

  }
  public void reverse (){
    m_differentialDrive.arcadeDrive(.75, 0);
  }
}

  
