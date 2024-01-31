// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.AmpConstants;

public class AmpTop extends SubsystemBase {
  private CANSparkMax m_ampShooter1 = new CANSparkMax(AmpConstants.kAmpShooterID1, MotorType.kBrushless);
  private CANSparkMax m_ampShooter2 = new CANSparkMax(AmpConstants.kAmpShooterID2, MotorType.kBrushless);
  private MotorControllerGroup m_shooters = new MotorControllerGroup(m_ampShooter1, m_ampShooter2);
  /** Creates a new AmpShooterSubsystem. */
  public AmpTop() {
    m_ampShooter2.setInverted(true);
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
