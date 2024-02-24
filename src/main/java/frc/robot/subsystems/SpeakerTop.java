// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class SpeakerTop extends SubsystemBase {
  private TalonFX m_speakerShooter1 = new TalonFX(MechanismConstants.kSpeakerShoot1MotorId);
  private TalonFX m_speakerShooter2 = new TalonFX(MechanismConstants.kSpeakerShoot2MotorId);
  private TalonFX m_speakerKicker = new TalonFX(MechanismConstants.kSpeakerKickerMotorId);
  private Follower m_speakerShooter2Follower = new Follower(MechanismConstants.kSpeakerShoot1MotorId, true);
  /** Creates a new AmpShooterSubsystem. */
  public SpeakerTop() {}

  public void shoot(){
    m_speakerShooter1.set(MechanismConstants.kSpeakerMainShootSpeed);
  }
  public void kick(){
    m_speakerKicker.set(MechanismConstants.kSpeakerKickerShootSpeed);
  }
  public void stop(){
    m_speakerShooter1.set(0);
    m_speakerKicker.set(0);
  }
  public void intake(){
    m_speakerShooter1.set(MechanismConstants.kSpeakerMainIntakeSpeed);
    m_speakerKicker.set(MechanismConstants.kSpeakerKickerIntakeSpeed);
  }

  @Override
  public void periodic() {
    m_speakerShooter2.setControl(m_speakerShooter2Follower);
  }
}
