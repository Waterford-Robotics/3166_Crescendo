package frc.robot;

public final class Constants {

  // Constants go here. It's standard to separate them into static inner classes. An example is created below.

  public static final class DriveConstants {
    public static final int kAmpShooterID1 = 19;
    public static final int kAmpShooterID2 = 20;
    public static final double kAmpShooterSpeed = 0.65;

  }
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }
  // This class cannot be initialized.
  private Constants() {}
}
