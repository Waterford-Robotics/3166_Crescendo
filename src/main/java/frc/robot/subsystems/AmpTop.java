// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class AmpTop extends SubsystemBase {
  private TalonFX m_shooters = new TalonFX(MechanismConstants.kAmpShaftMotorId);
  /** Creates a new AmpShooterSubsystem. */
  public AmpTop() {

  }

  public void release(){
    m_shooters.set(MechanismConstants.kAmpShootingSpeed);
  }
  public void reverse(){
    m_shooters.set(MechanismConstants.kAmpReverseSpeed);
  }
  public void stop(){
    m_shooters.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
