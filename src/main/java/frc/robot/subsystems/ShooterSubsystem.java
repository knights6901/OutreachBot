package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
    public final TalonFX leftMotor = new TalonFX(ShooterConstants.kLeftShooterId);
    public final TalonFX rightMotor = new TalonFX(ShooterConstants.kRightShooterId);

    public ShooterSubsystem() {
        leftMotor.getConfigurator().apply(ShooterConstants.kConfig);
        rightMotor.getConfigurator().apply(ShooterConstants.kConfig);

        rightMotor.setControl(new Follower(ShooterConstants.kLeftShooterId, MotorAlignmentValue.Opposed));

        setDefaultCommand(new RunCommand(() -> leftMotor.setControl(new NeutralOut()), this));
    }

    public Command shoot(double power) {
        return run(() -> leftMotor.set(power));
    }
}