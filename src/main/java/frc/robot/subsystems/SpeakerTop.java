package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class SpeakerTop {
    private Talon m_doubleshootMotor = new Talon(Constants.kDoubleShootmotorID);
    private Talon m_shootMotor = new Talon(Constants.kShootmotorID);
    private Talon m_kicker = new Talon(Constants.kKickerID);

    public void intake (){
        m_shootMotor.set(Constants.kIntakeSpeed);
        m_doubleshootMotor.set(-Constants.kIntakeSpeed);
        m_kicker.set(Constants.kIntakeSpeed);
    }
    public void stop (){
        m_shootMotor.set(0);
        m_doubleshootMotor.set(0);
        m_kicker.set(0);
    }
    public void shoot (){
        m_shootMotor.set(-Constants.kShootSpeed);
        m_doubleshootMotor.set(Constants.kShootSpeed);
        m_kicker.set(-Constants.kShootSpeed);
    }
}
