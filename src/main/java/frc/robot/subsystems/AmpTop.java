package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class AmpTop {
    Talon m_beltmotor = new Talon(Constants.beltmotorID);
    Talon m_shaftmotor = new Talon(Constants.shaftmotorID);
  
    public void shoot (){
      m_beltmotor.set(Constants.shootSpeed);
      m_shaftmotor.set(Constants.shootSpeed);
    }
    public void stop (){
      m_beltmotor.set(0);
      m_shaftmotor.set(0);
    }
}
