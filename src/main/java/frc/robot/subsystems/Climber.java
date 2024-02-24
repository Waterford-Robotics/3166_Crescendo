// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;;

public class Climber extends SubsystemBase {
  private TalonFX m_climbMotor1 = new TalonFX(MechanismConstants.kClimberLeftMotorId);
  private TalonFX m_climbMotor2 = new TalonFX(MechanismConstants.kClimberRightMotorId);
  private Follower m_climbMotor2Follower = new Follower(MechanismConstants.kClimberLeftMotorId, true);
  public Climber() {}

  public void climb(){
    m_climbMotor1.set(MechanismConstants.kClimberSpeed);
  }
  public void stop(){
    m_climbMotor1.set(0);
  }

  @Override
  public void periodic() {
    m_climbMotor2.setControl(m_climbMotor2Follower);  
  }
}
