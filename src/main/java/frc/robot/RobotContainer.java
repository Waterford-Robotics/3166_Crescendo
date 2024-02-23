// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SpeakerTop;

public class RobotContainer {
  private final SpeakerTop m_speakerShooter = new SpeakerTop();
  private XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  private final Drivetrain m_robotDrive = new Drivetrain();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getLeftY(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getLeftX(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRightX(), OIConstants.kDriveDeadband),
                true, true),
            m_robotDrive));
  }

  private void configureButtonBindings() {
    new JoystickButton(m_driverController, OIConstants.kMakeXButtonID)
        .whileTrue(new RunCommand(
            () -> m_robotDrive.setX(),
            m_robotDrive));

    new JoystickButton(m_driverController, OIConstants.kSpeakerShootButtonId)
      .whileTrue(new RunCommand(
        () -> m_speakerShooter.mainshoot(), 
        m_speakerShooter).finallyDo((interrupted) -> {
          m_speakerShooter.stop();
        }));
    new JoystickButton(m_driverController, OIConstants.kSpeakerKickButtonId)
      .whileTrue(new RunCommand(
        () -> m_speakerShooter.kickershoot(), 
        m_speakerShooter).finallyDo((interrupted) -> {
          m_speakerShooter.stop();
        }));
    new JoystickButton(m_driverController, OIConstants.kSpeakerIntakeButtonId)
      .whileTrue(new RunCommand(
        () -> m_speakerShooter.intake(), 
        m_speakerShooter).finallyDo((interrupted) -> {
          m_speakerShooter.stop();
        }));
  }

  public Command getAutonomousCommand() {
    return new InstantCommand(() -> m_robotDrive.resetOdometry(m_robotDrive.getPose()));
  }
}
