
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class KickerSubsystem extends SubsystemBase {
    public TalonFX kickerMotor = new TalonFX(37);

    public KickerSubsystem() {

    }

    public Command start() {
        return run(() -> kickerMotor.set(0.2));
    }
}
