// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.AmpConstants;

/**
 * The scoring mechanism for the amp.
 */
public class AmpTop extends SubsystemBase {

  private Talon m_motor = new Talon(AmpConstants.kShaftMotorId);

  /** Creates a new AmpTop. */
  public AmpTop() {
    // Run any final initializing steps here. Most instance variables should be instantiated in their declaration.
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runForward() {
    m_motor.set(AmpConstants.kRunSpeed);
  }

  public void reverse() {
    m_motor.set(AmpConstants.kReverseSpeed);
  }

  public void stop() {
    m_motor.stopMotor();
  }
}
