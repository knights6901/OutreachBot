package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  private TalonFX leftShooterMotor = new TalonFX(ShooterConstants.kLeftShooterId);
  private TalonFX rightShooterMotor = new TalonFX(ShooterConstants.kRightShooterId);
  private VelocityVoltage velocityRequest = new VelocityVoltage(0);
  public ShooterSubsystem() {
    leftShooterMotor.getConfigurator().apply(ShooterConstants.kConfig);
    rightShooterMotor.getConfigurator().apply(ShooterConstants.kConfig);

    rightShooterMotor.setControl(new Follower(ShooterConstants.kLeftShooterId, MotorAlignmentValue.Opposed));

    setDefaultCommand(new RunCommand(() -> leftShooterMotor.setControl(new NeutralOut()), this));
  }


  public void setShooterSpeed(double rps) {
    leftShooterMotor.setControl(velocityRequest.withVelocity(rps));
  }
    
}
