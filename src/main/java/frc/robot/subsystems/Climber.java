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

  private Talon m_motor = new Talon(ClimberConstants.kMotorId);

  /** Creates a new Climber. */
  public Climber() {

  }

  @Override
  public void periodic() {}

  public void climb() {
    m_motor.set(-ClimberConstants.kMotorSpeed);
  }

  public void descend() {
    m_motor.set(ClimberConstants.kMotorSpeed);
  }

  public void stop() {
    m_motor.set(0);
  }
}
