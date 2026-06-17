
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.KickerConstants;

public class KickerSubsystem extends SubsystemBase {
    public TalonFX kickerMotor = new TalonFX(KickerConstants.kKickerId);

    public KickerSubsystem() {
        kickerMotor.getConfigurator().apply(KickerConstants.kConfig);
    }

    public Command start() {
        return run(() -> kickerMotor.set(0.2));
    }
}
