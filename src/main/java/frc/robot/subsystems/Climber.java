// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

/**
 * The climbing mechanism.
 */
public class Climber extends SubsystemBase {

  private Talon m_leftMotor = new Talon(ClimberConstants.kLeftMotorId);
  private Talon m_rightMotor = new Talon(ClimberConstants.kRightMotorId);

  /** Creates a new Climber. */
  public Climber() {
    m_leftMotor.addFollower(m_rightMotor);

    m_rightMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb() {
    m_leftMotor.set(ClimberConstants.kMotorSpeed);
  }

  public void descend() {
    m_leftMotor.set(-ClimberConstants.kMotorSpeed);
  }

  public void stop() {
    m_leftMotor.set(0);
  }
}
