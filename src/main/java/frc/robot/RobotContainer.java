// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.OIConstants;
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
  private final SpeakerTop m_speakerTop = new SpeakerTop();
  private final Climber m_climber = new Climber();


  // The drivers' controllers
  private final XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);  
  double timeDelay;

  SendableChooser<Command> m_pathplannerchooser = AutoBuilder.buildAutoChooser();
  SendableChooser<Boolean> m_fieldrelativechooser = new SendableChooser<>();
  SendableChooser<Double> m_timeDelayChooser = new SendableChooser<>();
  public void periodic(){
    SmartDashboard.putData(m_pathplannerchooser);
    SmartDashboard.putData(m_fieldrelativechooser);
    SmartDashboard.putData(m_timeDelayChooser);
    timeDelay = m_timeDelayChooser.getSelected();
  }
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    NamedCommands.registerCommand("Shoot", new RunCommand(() -> m_speakerTop.shoot(), m_speakerTop).withTimeout(1));
    NamedCommands.registerCommand("Kick", new RunCommand(() -> m_speakerTop.kick(), m_speakerTop).withTimeout(1));
    NamedCommands.registerCommand("AmpKick", new RunCommand(() -> m_speakerTop.ampkick(), m_speakerTop).withTimeout(1));
    NamedCommands.registerCommand("AmpFinish", new RunCommand(() -> m_speakerTop.ampfinish(), m_speakerTop).withTimeout(1));
    NamedCommands.registerCommand("SpeakerStop", new InstantCommand(() -> m_speakerTop.stop(), m_speakerTop));

    SmartDashboard.putData("Auto Chooser", m_pathplannerchooser);
    m_fieldrelativechooser.setDefaultOption("Field Relative", true);
    m_fieldrelativechooser.addOption("Robot Relative", false);
    m_timeDelayChooser.setDefaultOption("0 seconds", 0.0);
    m_timeDelayChooser.addOption("4 seconds", 4.0);
    m_timeDelayChooser.addOption("8 seconds", 8.0);
    m_timeDelayChooser.addOption("10 seconds", 10.0);
    timeDelay = m_timeDelayChooser.getSelected();
    SmartDashboard.putData(m_pathplannerchooser);
    SmartDashboard.putData(m_fieldrelativechooser);
    SmartDashboard.putData(m_timeDelayChooser);
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
              m_fieldrelativechooser.getSelected(), true),
            m_robotDrive));
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
        .whileTrue(new RunCommand(() -> m_robotDrive.setX(), m_robotDrive));

    new JoystickButton(m_driverController, OIConstants.kAmpShootButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::ampfinish, m_speakerTop::stop));

    new JoystickButton(m_driverController, OIConstants.kAmpKickButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::ampkick, m_speakerTop::stop));

    new Trigger(() -> m_driverController.getRawAxis(OIConstants.kSpeakerShootButtonId)> 0.05)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::shoot, m_speakerTop::stop));

    new Trigger (() -> m_driverController.getRawAxis(OIConstants.kSpeakerKickButtonId)>0.05)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::kick, m_speakerTop::stop));
    
    new JoystickButton(m_driverController, OIConstants.kSpeakerIntakeButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::intake, m_speakerTop::stop));

    new JoystickButton(m_driverController, OIConstants.kClimbAscendButtonId)
        .whileTrue(m_climber.startEnd(m_climber::climb, m_climber::stop));
    
    new JoystickButton(m_driverController, OIConstants.kClimbDescendAxisId)
        .whileTrue(m_climber.startEnd(m_climber::descend, m_climber::stop));   
  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_pathplannerchooser.getSelected();
  }
}
