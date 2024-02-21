package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class AmpTop {

    private Talon m_shaftMotor = new Talon(Constants.kAmpShaftMotorId);
  
    public void shoot() {
      m_shaftMotor.set(-Constants.kAmpShootSpeed);
    }

    public void reverse() {
      m_shaftMotor.set(Constants.kAmpShootSpeed);
    }

    public void stop() {
      m_shaftMotor.set(0);
    }

}
