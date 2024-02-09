// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpeakerConstants;

public class SpeakerTop extends SubsystemBase {
  private CANSparkMax m_speakerShooter1 = new CANSparkMax(SpeakerConstants.kSpeakerShooterID1, MotorType.kBrushless);
  private CANSparkMax m_speakerShooter2 = new CANSparkMax(SpeakerConstants.kSpeakerShooterID2, MotorType.kBrushless);
  private MotorControllerGroup m_speakerShooters = new MotorControllerGroup(m_speakerShooter1, m_speakerShooter2);
  private CANSparkMax m_speakerKicker = new CANSparkMax(SpeakerConstants.kSpeakerKickerID, MotorType.kBrushless);
  /** Creates a new AmpShooterSubsystem. */
  public SpeakerTop() {}

  public void shoot(){
    m_speakerShooters.set(SpeakerConstants.kShooterSpeed);
    m_speakerKicker.set(SpeakerConstants.kKickerSpeed);
  }
  public void stop(){
    m_speakerShooters.set(0);
    m_speakerKicker.set(0);
  }
  public void intake(){
    m_speakerShooters.set(SpeakerConstants.kShooterIntakeSpeed);
    m_speakerKicker.set(SpeakerConstants.kKickerIntakeSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
