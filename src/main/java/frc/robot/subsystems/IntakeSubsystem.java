package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    private TalonFX motor = new TalonFX(IntakeConstants.Id);

    public IntakeSubsystem() {
        motor.getConfigurator().apply(IntakeConstants.Config);
    }

    public Command start() {
        return run(() -> motor.setControl(new DutyCycleOut(0.3)));
    }

    public Command stop() {
        return run(() -> motor.setControl(new NeutralOut()));
    }
}
