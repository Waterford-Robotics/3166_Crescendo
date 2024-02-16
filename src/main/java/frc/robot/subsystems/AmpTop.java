package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class AmpTop {
    private Talon m_shaftmotor = new Talon(Constants.kAmpShaftmotorId);
  
    public void shoot() {
      m_shaftmotor.set(-Constants.kShootSpeed);
    }
    public void stop() {
      m_shaftmotor.set(0);
    }
}
