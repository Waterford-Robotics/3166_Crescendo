package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public final class AmpTop {
    Talon m_beltmotor = new Talon(0);
    Talon m_shaftmotor = new Talon(0);
  
    public void shoot (){
      m_beltmotor.set(.7);
      m_shaftmotor.set(.7);
    }
    public void shootfinish (){
      m_beltmotor.set(0);
      m_shaftmotor.set(0);
    }
}
