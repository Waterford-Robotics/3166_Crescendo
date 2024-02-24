package frc.robot;

public final class Constants {

  // Motor controller IDs
  public static final int kShoot1MotorId = 9;
  public static final int kShoot2MotorId = 8;
  public static final int kKickerShootMotorId =7;
  
  public static final int kAmpShaftMotorId = 6;
  public static final int kClimberLeftMotorId = 4;
  public static final int kClimberRightMotorId = 5;
  
  public static final int kRight1DriveMotorId = 0;
  public static final int kRight2DriveMotorId = 1;
  public static final int kLeft1DriveMotorId = 2;
  public static final int kLeft2DriveMotorId = 3;

  // Controller ports
  public static final int kDriverControllerPort = 0;
  public static final int kOperatorControllerPort = 1;

  // Input IDs
  public static final int kDriverControllerForwardAxisId = 1;
  public static final int kDriverControllerTurningAxisId = 4;

  public static final int kAmpShootButtonId = 2;
  public static final int kAmpReverseButtonId = 4;

  public static final int kSpeakIntakeButtonId = 3;

  // Speeds
  public static final double kMoveSpeed = 0.95;
  public static final double kAmpShootSpeed = 0.8;
  public static final double kSpeakShootSpeed = 0.95;
  public static final double kSpeakKickerShootSpeed = 0.9;
  public static final double kSpeakReverseSpeed = 0.7;
  public static final double kClimbSpeed = 0.5;
  
  // This class cannot be initalized.
  private Constants() {}
}
