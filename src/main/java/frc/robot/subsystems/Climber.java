// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Climber extends SubsystemBase {
  private WPI_TalonFX m_climbMotor = new WPI_TalonFX(DriveConstants.kClimberID);
  public Climber() {}

  public void climb(){
    m_climbMotor.set(DriveConstants.kClimberSpeed);
  }
  public void stop(){
    m_climbMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
