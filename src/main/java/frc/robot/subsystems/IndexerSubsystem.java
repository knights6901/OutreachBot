package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
    public TalonFX motor = new TalonFX(0);

    public IndexerSubsystem() {

    }

    public Command start() {
        return run(() -> motor.set(0.7));
    }
}
