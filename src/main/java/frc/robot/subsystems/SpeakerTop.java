// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpeakerConstants;

/**
 * The scoring mechanism for the speaker.
 */
public class SpeakerTop extends SubsystemBase {
  // shoot motor 2 is on the bottom
  private Talon m_shootMotor1 = new Talon(SpeakerConstants.kShoot1MotorId);
  private Talon m_shootMotor2 = new Talon(SpeakerConstants.kShoot2MotorId);
  private Talon m_kickerMotor = new Talon(SpeakerConstants.kKickerMotorId);
  
  /** Creates a new Shooter. */
  public SpeakerTop() {
    m_shootMotor1.addFollower(m_shootMotor2);
    m_shootMotor1.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void ampfinish() {
    m_shootMotor1.set(-SpeakerConstants.kAmpTopSpeed);
    m_shootMotor2.set(SpeakerConstants.kAmpBottomSpeed);
  }
  
  public void ampkick() {
    m_shootMotor1.set(SpeakerConstants.kAmpTopSpeed);
    m_shootMotor2.set(SpeakerConstants.kAmpBottomSpeed);
    m_kickerMotor.set(SpeakerConstants.kKickerSpeed);
  }

  public void shoot() {
    m_shootMotor1.set(SpeakerConstants.kShootSpeed);
  }

  public void kick() {
    m_kickerMotor.set(SpeakerConstants.kKickerSpeed);
    m_shootMotor1.set(SpeakerConstants.kShootSpeed);
  }

  public void intake() {
    m_shootMotor1.set(SpeakerConstants.kReverseSpeed);
    m_kickerMotor.set(-SpeakerConstants.kKickerSpeed);
  }

  public void stop() {
    m_shootMotor1.set(0);
    m_kickerMotor.set(0);
  }

  public void feedstart(){
    m_shootMotor1.set(-SpeakerConstants.kFeedTopSpeed);
    m_shootMotor2.set(SpeakerConstants.kFeedBottomSpeed);
  }
  
  public void feedfinish(){
    m_shootMotor1.set(-SpeakerConstants.kFeedTopSpeed);
    m_shootMotor2.set(SpeakerConstants.kFeedBottomSpeed);
    m_kickerMotor.set(SpeakerConstants.kKickerSpeed);
  }
}
