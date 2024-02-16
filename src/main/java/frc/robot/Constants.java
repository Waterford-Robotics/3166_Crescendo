package frc.robot;

public final class Constants {

  // Constants go here...
  public static final int kDriverControllerPort = 0;
  public static final int kOperatorControllerPort = 1;

  public static final int kShootmotor1ID = 9;
  public static final int kShootmotor2ID =8;
  public static final int kKickerShootmotorID =7;
  
  public static final int kAmpShaftmotorId = 6;
  
  public static final int kRight1DriveMotorId = 0;
  public static final int kRight2DriveMotorId = 1;
  public static final int kLeft1DriveMotorId = 2;
  public static final int kLeft2DriveMotorId = 3;
  
  public static final int kDriverControllerForwardAxisId = 1;
  public static final int kDriverControllerTurningAxisId = 4;

  public static final double kMoveSpeed = 0.7;
  public static final double kShootSpeed = 1.0;
  public static final double kSpeakKickerShootSpeed = 0.8;

  public static final int kAmpShootButtonId = 2;
  public static final int kSpeakShootButtonID = 3;  
  // This class cannot be initalized.
  private Constants() {}
}
