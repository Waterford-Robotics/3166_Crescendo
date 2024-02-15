// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Optional;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Drivetrain;

public class AimAndDriveWithControllerCommand extends Command {

  private static final double kP = 0.0;
  private static final double kI = 0.0;
  private static final double kD = 0.0;

  private Drivetrain m_drivetrain;
  private PhotonCamera m_camera;

  private XboxController m_manualController;
  private int m_fiducialId;

  private PIDController m_turnController = new PIDController(kP, kI, kD);

  /** Creates a new AimAndDriveCommand. */
  public AimAndDriveWithControllerCommand(Drivetrain drivetrain, PhotonCamera camera, XboxController controller, int targetFiducialId) {
    addRequirements(drivetrain);

    m_drivetrain = drivetrain;
    m_camera = camera;
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
    double angleErrorDegrees = getError();
    
    m_drivetrain.drive(-MathUtil.applyDeadband(m_manualController.getLeftY(), OIConstants.kDriveDeadband),
                       -MathUtil.applyDeadband(m_manualController.getLeftX(), OIConstants.kDriveDeadband),
                       m_turnController.calculate(angleErrorDegrees),
                       true, true);
  }

  private double getError() {
    PhotonPipelineResult result = m_camera.getLatestResult();
    if (!result.hasTargets()) {
      return 0;
    }

    Optional<PhotonTrackedTarget> target = result.targets.stream()
      .filter(x -> x.getFiducialId() == m_fiducialId)
      .findFirst();
    
    if (target.isPresent()) {
      return -target.get().getYaw();
    } else {
      return 0;
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
