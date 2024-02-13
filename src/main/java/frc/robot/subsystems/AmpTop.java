// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.AmpConstants;

public class AmpTop extends SubsystemBase {
  private TalonFX m_shooters = new TalonFX(AmpConstants.kAmpShooterID1);
  /** Creates a new AmpShooterSubsystem. */
  public AmpTop() {

  }

  public void shoot(){
    m_shooters.set(AmpConstants.kAmpShooterSpeed);
  }
  public void stop(){
    m_shooters.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
