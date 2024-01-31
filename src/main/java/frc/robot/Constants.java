package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;

public final class Constants {

  // Constants go here. It's standard to separate them into static inner classes. An example is created below.
  public static final class DriveConstants {}

  public static final class ClimberConstants {
    public static final int kClimberID1 = 18;
    public static final int kClimberID2 = 19;
    public static final double kClimberSpeed = 0.85;
  }
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kXButton = Button.kX.value;
  }
  // This class cannot be initialized.
  private Constants() {}
}
