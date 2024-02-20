package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class Climber {
    
    private Talon m_lcmotor = new Talon(Constants.kLcmotorID);
    private Talon m_rcmotor = new Talon(Constants.kRcmotorID);

    public Climber() {
        m_rcmotor.setInverted(true);
    }
    public void climb(){
        m_lcmotor.set(Constants.kClimbSpeed);
        m_rcmotor.set(Constants.kClimbSpeed);
    } 
    public void stop(){
        m_lcmotor.set(0);
        m_rcmotor.set(0);
    }
    public void descend(){
        m_lcmotor.set(-Constants.kClimbSpeed);
        m_rcmotor.set(-Constants.kClimbSpeed);
    }
}
