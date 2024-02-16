package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class SpeakerTop {
    private Talon m_shootMotor1 = new Talon(Constants.kShootmotor1ID);
    private Talon m_shootMotor2 = new Talon(Constants.kShootmotor2ID);
    private Talon m_shootMotor3 = new Talon(Constants.kKickerShootmotorID);

    public void shoot (){
        m_shootMotor1.set(Constants.kShootSpeed);
        m_shootMotor2.set(-Constants.kShootSpeed);
        m_shootMotor3.set(Constants.kSpeakKickerShootSpeed);
    }
    public void stop (){
        m_shootMotor1.set(0);
        m_shootMotor2.set(0);
        m_shootMotor3.set(0);
    }
    public void reverse (){
        m_shootMotor1.set(-Constants.kShootSpeed);
        m_shootMotor2.set(Constants.kShootSpeed);
        m_shootMotor3.set(-Constants.kSpeakKickerShootSpeed);
    }
}
