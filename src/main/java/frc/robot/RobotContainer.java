// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.ConversionFactors;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SpeakerTop;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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
  private final XboxController m_operatorController = new XboxController(OIConstants.kOperatorControllerPort);

  public void periodic(){
    SmartDashboard.putData(m_chooser);
  }
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_chooser.setDefaultOption("Nothing Auto", m_nothingAuto);
    m_chooser.addOption("Drive Out Auto", m_driveOutAuto);
    m_chooser.addOption("Close to Amp Auto", m_closeAmpAuto);
    m_chooser.addOption("Middle to Amp Auto", m_middleAmpAuto);
    m_chooser.addOption("Far to Amp Auto",m_farAmpAuto);
    m_chooser.addOption("In and Out Auto", m_driveInOutAuto);
    SmartDashboard.putData(m_chooser);
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

    new JoystickButton(m_operatorController, OIConstants.kAmpShootButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::ampshoot, m_speakerTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kAmpKickButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::ampkick, m_speakerTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kSpeakerShootButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::shoot, m_speakerTop::stop));

    new JoystickButton(m_operatorController, OIConstants.kSpeakerKickButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::kick, m_speakerTop::stop));
    
    new JoystickButton(m_operatorController, OIConstants.kSpeakerIntakeButtonId)
        .whileTrue(m_speakerTop.startEnd(m_speakerTop::intake, m_speakerTop::stop));

    new Trigger(() -> m_operatorController.getRawAxis(OIConstants.kClimbAscendAxisId) > 0.05)
        .whileTrue(m_climber.startEnd(m_climber::climb, m_climber::stop));
    
    new Trigger(() -> m_operatorController.getRawAxis(OIConstants.kClimbDescendAxisId) > 0.05)
        .whileTrue(m_climber.startEnd(m_climber::descend, m_climber::stop));   
  }
  
  // shooter auto when close to amp
  private final Command m_closeAmpAuto = Commands.sequence(
      new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()),m_robotDrive),
      new RunCommand(() -> m_speakerTop.shoot(),m_speakerTop)
        .withTimeout(1),
      new RunCommand(() -> m_speakerTop.kick(), m_speakerTop)
        .withTimeout(1),
      new InstantCommand(() -> m_speakerTop.stop(), m_speakerTop),
      new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed,0,0,false,false),m_robotDrive)
        .until(() -> m_robotDrive.getPose().getX()<-30*ConversionFactors.kInchesToMeters),
      new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()),m_robotDrive),
      new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed,0,0,true,false), m_robotDrive)
        .until(() -> m_robotDrive.getPose().getX()<-80*ConversionFactors.kInchesToMeters)
      .finallyDo((interrupted) -> {m_robotDrive.drive(0,0,0,false,false);}));
  
  // shooter auto when middle to amp    
  private final Command m_middleAmpAuto = Commands.sequence(
      new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()), m_robotDrive),
      new RunCommand(() -> m_speakerTop.shoot(), m_speakerTop)
        .withTimeout(1),
      new RunCommand(() -> m_speakerTop.kick(), m_speakerTop)
        .withTimeout(1),
      new InstantCommand(() -> m_speakerTop.stop(), m_speakerTop),
      new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed, 0, 0, false,false), m_robotDrive)
        .until(() -> m_robotDrive.getPose().getX()<-80*ConversionFactors.kInchesToMeters)
      )
      .finallyDo((interrupted) -> {m_robotDrive.drive(0, 0, 0, false,false);});
  
  // shooter auto when far from amp
  private final Command m_farAmpAuto = Commands.sequence(
      new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()),m_robotDrive),
      new RunCommand(() -> m_speakerTop.shoot(),m_speakerTop)
        .withTimeout(1),
      new RunCommand(() -> m_speakerTop.kick(), m_speakerTop)
        .withTimeout(1),
      new InstantCommand(() -> m_speakerTop.stop(), m_speakerTop),
      new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed,0,0,false,false),m_robotDrive)
        .until(() -> m_robotDrive.getPose().getX()<-120*ConversionFactors.kInchesToMeters),
      new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()),m_robotDrive),
      new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed,0,0,true,false), m_robotDrive)
        .until(() -> m_robotDrive.getPose().getX()<-60*ConversionFactors.kInchesToMeters)
      .finallyDo((interrupted) -> {m_robotDrive.drive(0,0,0,false,false);}));

  // drives straight out
  private final Command m_driveOutAuto = Commands.sequence(
    new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()), m_robotDrive),
    new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed,0,0,true,false),m_robotDrive)
      .until(() -> m_robotDrive.getPose().getX()<-120*ConversionFactors.kInchesToMeters)
    .finallyDo((interrupted) -> {m_robotDrive.drive(0,0,0,false,false);}));
  
  // drive in and out
  private final Command m_driveInOutAuto = Commands.sequence(
    new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()), m_robotDrive),
    new RunCommand(() -> m_robotDrive.drive(AutoConstants.kAutoSpeed, 0, 0, true, false),m_robotDrive)
      .withTimeout(2),
    new RunCommand(() -> m_robotDrive.drive(-AutoConstants.kAutoSpeed, 0, 0, true, false),m_robotDrive)
      .withTimeout(3)
    .finallyDo((interrupted) -> {m_robotDrive.drive(0,0,0,false,false);}));
  
    // does nothing
  private final Command m_nothingAuto = Commands.sequence(
    new InstantCommand(() -> m_robotDrive.resetOdometry(new Pose2d()),m_robotDrive));
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
