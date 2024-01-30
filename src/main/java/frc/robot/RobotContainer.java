// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.SpeakerTop;

public class RobotContainer {
  private final SpeakerTop m_speakerShooter = new SpeakerTop();
  private XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);

  // Instance variables go here. This typically includes all robot systems and controllers.

  public RobotContainer() {
    m_speakerShooter.setDefaultCommand(
      new RunCommand(() -> m_speakerShooter.stop(), m_speakerShooter)
    );

    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(m_driverController, Button.kY.value)
    .whileTrue(new RunCommand(
        () -> m_speakerShooter.shoot(), 
        m_speakerShooter));
    new JoystickButton(m_driverController, Button.kA.value)
    .whileTrue(new RunCommand(
        () -> m_speakerShooter.intake(), 
        m_speakerShooter));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
