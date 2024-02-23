// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.AmpTop;

public class RobotContainer {
  private final AmpTop m_ampShooter = new AmpTop();

  private XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  // Instance variables go here. This typically includes all robot systems and controllers.

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_driverController, OIConstants.kBButton)
    .whileTrue(new RunCommand(
      () -> m_ampShooter.shoot(), 
      m_ampShooter).finallyDo((interrupted) -> {
        m_ampShooter.stop();
      }));
    new JoystickButton(m_driverController, OIConstants.kYButton)
    .whileTrue(new RunCommand(
      () -> m_ampShooter.shoot(),
      m_ampShooter).finallyDo((interrupted) -> {
        m_ampShooter.stop();
      }));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
