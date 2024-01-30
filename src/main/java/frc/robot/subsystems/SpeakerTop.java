// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class SpeakerTop extends SubsystemBase {
  private CANSparkMax m_speakerShooter1 = new CANSparkMax(DriveConstants.kSpeakerShooterID1, MotorType.kBrushless);
  private CANSparkMax m_speakerKicker = new CANSparkMax(DriveConstants.kSpeakerKickerID, MotorType.kBrushless);
  /** Creates a new AmpShooterSubsystem. */
  public SpeakerTop() {}

  public void shoot(){
    m_speakerShooter1.set(DriveConstants.kShooterSpeed);
    m_speakerKicker.set(DriveConstants.kKickerSpeed);
  }
  public void stop(){
    m_speakerShooter1.set(0);
    m_speakerKicker.set(0);
  }
  public void intake(){
    m_speakerShooter1.set(DriveConstants.kShooterIntakeSpeed);
    m_speakerKicker.set(DriveConstants.kKickerIntakeSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
