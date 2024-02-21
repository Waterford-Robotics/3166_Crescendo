package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class Climber {

  private Talon m_leftMotor = new Talon(Constants.kClimberLeftMotorId);
  private Talon m_rightMotor = new Talon(Constants.kClimberRightMotorId);

  public Climber() {
    m_rightMotor.setInverted(true);
  }

  public void climb() {
    m_leftMotor.set(Constants.kClimbSpeed);
    m_rightMotor.set(Constants.kClimbSpeed);
  } 

  public void stop() {
    m_leftMotor.set(0);
    m_rightMotor.set(0);
  }

  public void descend() {
    m_leftMotor.set(-Constants.kClimbSpeed);
    m_rightMotor.set(-Constants.kClimbSpeed);
  }

}
