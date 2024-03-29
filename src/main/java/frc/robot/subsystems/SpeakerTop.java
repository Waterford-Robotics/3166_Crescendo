package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public final class SpeakerTop {

    private Talon m_shootMotor1 = new Talon(Constants.kShoot1MotorId);
    private Talon m_shootMotor2 = new Talon(Constants.kShoot2MotorId);
    private Talon m_shootMotor3 = new Talon(Constants.kKickerShootMotorId);

    public void shoot() {
        m_shootMotor1.set(-Constants.kSpeakShootSpeed);
        m_shootMotor2.set(-Constants.kSpeakShootSpeed);
    }

    public void kicker() {
        m_shootMotor3.set(Constants.kSpeakKickerShootSpeed);
    }

    public void stop() {
        m_shootMotor1.set(0);
        m_shootMotor2.set(0);
        m_shootMotor3.set(0);
    }

    public void reverse() {
        m_shootMotor1.set(Constants.kSpeakReverseSpeed);
        m_shootMotor2.set(Constants.kSpeakReverseSpeed);
        m_shootMotor3.set(-Constants.kSpeakKickerShootSpeed);
    }

}
//x=intake, right bumper rollershot, left b kicker shoot.