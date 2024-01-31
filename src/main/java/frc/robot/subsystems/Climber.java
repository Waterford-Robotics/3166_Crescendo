// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class Climber extends SubsystemBase {
  private WPI_TalonFX m_climbMotor1 = new WPI_TalonFX(ClimberConstants.kClimberID1);
  private WPI_TalonFX m_climbMotor2 = new WPI_TalonFX(ClimberConstants.kClimberID2);
  private MotorControllerGroup m_climbMotors = new MotorControllerGroup(m_climbMotor1, m_climbMotor2);
  public Climber() {
    m_climbMotor2.setInverted(true);
  }

  public void climb(){
    m_climbMotors.set(ClimberConstants.kClimberSpeed);
  }
  public void stop(){
    m_climbMotors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
