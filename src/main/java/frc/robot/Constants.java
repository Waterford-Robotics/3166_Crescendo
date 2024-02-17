package frc.robot;

public final class Constants {
  
  public static final int kRight1DriveMotorId = 0;
  public static final int kRight2DriveMotorId = 1;
  public static final int kLeft1DriveMotorId = 2;
  public static final int kLeft2DriveMotorId = 3;

  public static final int kShaftmotorId = 6;

  // Constants go here...
  public static final int kShootmotorID = 9;
  public static final int kDoubleShootmotorID =8;
  public static final int kKickerID = 7;

  public static final int kDriverControllerPort = 0;
  public static final int kDriverControllerForwardAxisId = 1;
  public static final int kDriverControllerTurningAxisId = 4;

  public static final int kOperatorControllerPort = 1;

  public static final double kIntakeSpeed = .6; 
  public static final double kShootSpeed = .75;
  public static final double kMoveSpeed = .8;
  
  public static final int kIntakeButtonID = 2;
  public static final int kShootButtonID = 3;
  // This class cannot be initalized.
  private Constants() {}
}
