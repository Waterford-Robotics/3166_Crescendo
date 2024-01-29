package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class AmpTop {
    Talon m_beltmotor = new Talon(Constants.kBeltmotorID);
    Talon m_shaftmotor = new Talon(Constants.kShaftmotorID);
  
    public void shoot (){
      m_beltmotor.set(Constants.kShootSpeed);
      m_shaftmotor.set(Constants.kShootSpeed);
    }
    public void stop (){
      m_beltmotor.set(0);
      m_shaftmotor.set(0);
    }
}
