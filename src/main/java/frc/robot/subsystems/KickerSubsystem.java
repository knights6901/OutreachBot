
package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.KickerConstants;

public class KickerSubsystem extends SubsystemBase {
    private TalonFX motor = new TalonFX(KickerConstants.Id);

    public KickerSubsystem() {
        motor.getConfigurator().apply(KickerConstants.Config);
    }

    public Command start() {
        return run(() -> motor.setControl(new DutyCycleOut(0.3)));
    }

    public Command stop() {
        return run(() -> motor.setControl(new NeutralOut()));
    }
}
