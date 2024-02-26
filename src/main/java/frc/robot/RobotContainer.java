// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.AmpTop;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SpeakerTop;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final Drivetrain m_robotDrive = new Drivetrain();
  private final AmpTop m_ampTop = new AmpTop();
  private final SpeakerTop m_speakerTop = new SpeakerTop();
  private final Climber m_climber = new Climber();

  // The drivers' controllers
  private final XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  private final XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Configure default commands
    /*m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getLeftY(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getLeftX(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRightX(), OIConstants.kDriveDeadband),
                true, true),
            m_robotDrive));*/
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driverController, OIConstants.kDriveSetXButtonId)
        .whileTrue(m_robotDrive.runOnce(m_robotDrive::setX));

    new JoystickButton(m_operatorController, OIConstants.kAmpShootButtonId)
        .whileTrue(m_ampTop.startEnd(m_ampTop::runForward, m_ampTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kAmpReverseButtonId)
        .whileTrue(m_ampTop.startEnd(m_ampTop::reverse, m_ampTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kSpeakerShootButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::shoot, m_speakerTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kSpeakerKickButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::shoot, m_speakerTop::stop));
    
    new JoystickButton(m_operatorController, OIConstants.kSpeakerIntakeButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::intake, m_speakerTop::stop));

    new Trigger(() -> m_operatorController.getRawAxis(OIConstants.kClimbAscendAxisId) > 0.05)
        .whileTrue(m_climber.startEnd(m_climber::climb, m_climber::stop));
    
    new Trigger(() -> m_operatorController.getRawAxis(OIConstants.kClimbDescendAxisId) > 0.05)
        .whileTrue(m_climber.startEnd(m_climber::descend, m_climber::stop));   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new InstantCommand(() -> m_robotDrive.resetOdometry(m_robotDrive.getPose()));
  }
}
