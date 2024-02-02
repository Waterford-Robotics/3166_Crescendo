// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The robot's drivetrain.
 */
public class Drivetrain extends SubsystemBase {

  // Instance variables go here...

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Run any final initializing steps here. Most instance variables should be instantiated in their declaration.
  }
  public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative, boolean rateLimit) {}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
