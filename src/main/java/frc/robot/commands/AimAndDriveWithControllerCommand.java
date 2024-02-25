// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Optional;

import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Drivetrain;

public class AimAndDriveWithControllerCommand extends Command {

  private static final double kP = 0.03;
  private static final double kI = 0.00;
  private static final double kD = 0.00;

  private Drivetrain m_drivetrain;

  private XboxController m_manualController;
  private int m_fiducialId;

  private PIDController m_turnController = new PIDController(kP, kI, kD);

  /** Creates a new AimAndDriveCommand. */
  public AimAndDriveWithControllerCommand(Drivetrain drivetrain, XboxController controller, int targetFiducialId) {
    addRequirements(drivetrain);

    m_drivetrain = drivetrain;
    m_manualController = controller;
    m_fiducialId = targetFiducialId;

    m_turnController.setSetpoint(0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double angleErrorDegrees = getError().orElseGet(() -> {
      Pose2d robotPose = m_drivetrain.getPose();
      Pose2d targetPose = m_drivetrain.getVisionDataProvider().getFieldLayout().getTagPose(m_fiducialId)
          .orElseThrow(() -> new IllegalArgumentException("The tag you requested (ID " + m_fiducialId + ") is not on the field"))
          .toPose2d();
      return -PhotonUtils.getYawToPose(robotPose, targetPose).getDegrees();
    });
    
    m_drivetrain.drive(-MathUtil.applyDeadband(m_manualController.getLeftY(), OIConstants.kDriveDeadband),
                       -MathUtil.applyDeadband(m_manualController.getLeftX(), OIConstants.kDriveDeadband),
                       m_turnController.calculate(angleErrorDegrees),
                       true, true);
  }

  private Optional<Double> getError() {
    Optional<PhotonTrackedTarget> target = m_drivetrain.getVisionDataProvider().getTargets().stream()
      .filter(x -> x.getFiducialId() == m_fiducialId)
      .findFirst();
    
    if (target.isPresent()) {
      return Optional.of(target.get().getYaw());
    } else {
      return Optional.empty();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
