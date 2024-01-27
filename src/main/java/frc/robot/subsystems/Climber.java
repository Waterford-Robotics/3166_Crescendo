package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public final class Climber {
    
    Talon m_lcmotor = new Talon(6);
    Talon m_rcmotor = new Talon(7);

    public void climb(){
        m_lcmotor.set(.7);
        m_rcmotor.set(.7);
    } 
    public void stop(){
        m_lcmotor.set(0);
        m_rcmotor.set(0);
    }
    public void descend(){
        m_lcmotor.set(-.7);
        m_rcmotor.set(-.7);
    }
}
