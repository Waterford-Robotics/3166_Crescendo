package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;

public final class Constants {

  // Constants go here. It's standard to separate them into static inner classes. An example is created below.

  public static final class DriveConstants {
    public static final int kSpeakerShooterID1 = 19;
    public static final int kSpeakerShooterID2 = 20;
    public static final int kSpeakerKickerID = 21;
    public static final double kShooterSpeed = 0.65;
    public static final double kKickerSpeed = 0.55;
    public static final double kShooterIntakeSpeed = -0.55;
    public static final double kKickerIntakeSpeed = -0.45;
  }
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAButton = Button.kA.value;
    public static final int kYButton = Button.kY.value;
  }
  // This class cannot be initialized.
  private Constants() {}
}
