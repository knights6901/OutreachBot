// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Percent;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.Second;
import static edu.wpi.first.units.Units.Seconds;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAdminControllerPort = 1;
  }

  public static class ShooterConstants {
    public static final int kLeftShooterId = 35;
    public static final int kRightShooterId = 36;

    public static final Slot0Configs Gains = new Slot0Configs()
        .withKP(0.36901).withKI(0).withKD(0.0085)
        .withKS(0).withKV(0.119);

    public static final TalonFXConfiguration kConfig = new TalonFXConfiguration()
        .withMotorOutput(new MotorOutputConfigs()
            .withNeutralMode(NeutralModeValue.Coast)
            .withInverted(InvertedValue.Clockwise_Positive))
        .withSlot0(Gains);
  }

  public static class KickerConstants {
    public static final int Id = 37;
    public static final double KickerSpeed = 0.2;

    public static final TalonFXConfiguration Config = new TalonFXConfiguration()
        .withMotorOutput(new MotorOutputConfigs()
            .withNeutralMode(NeutralModeValue.Coast)
            .withInverted(InvertedValue.Clockwise_Positive));
  }

  public static class IntakeConstants {
    public static final int Id = 32;
    public static final AngularVelocity Speed = RotationsPerSecond.of(67);

    public static final TalonFXConfiguration Config = new TalonFXConfiguration()
        .withMotorOutput(new MotorOutputConfigs()
            .withNeutralMode(NeutralModeValue.Coast)
            .withInverted(InvertedValue.Clockwise_Positive));
  }
  
  public static class IndexerConstants {
    public static final int Id = 40;

    public static final TalonFXConfiguration Config = new TalonFXConfiguration()
        .withMotorOutput(new MotorOutputConfigs()
            .withNeutralMode(NeutralModeValue.Coast)
            .withInverted(InvertedValue.Clockwise_Positive));
  }

  public static final class SlapdownConstants {
    /** The CAN ID of the slapdown motor. */
    public final static int MotorId = 31;

    /** The position to lower the slapdown to when intaking a ball. */
    public final static Angle IntakePosition = Rotations.of(62);
    /** The default home position of slapdown system. */
    public final static Angle HomePosition = Rotations.of(0);
    /**
     * The tolerance for determining whether the slapdown is in the deployed
     * position.
     */
    public final static Angle PositionTolerance = Rotations.of(1.0);

    /** The gear ratio of the slapdown system. */
    public final static double GearRatio = 81.0;

    /** The PID and feedforward settings for the slapdown motor. */
    public final static Slot0Configs Gains = new Slot0Configs()
                    .withKP(0.4).withKI(0).withKD(0.1)
                    .withKS(0).withKV(1.3);

    /** The complete motor configuration for the slapdown system. */
    public final static TalonFXConfiguration MotorConfig = new TalonFXConfiguration()
                    .withSlot0(SlapdownConstants.Gains)
                    .withMotorOutput(new MotorOutputConfigs()
                                    .withNeutralMode(NeutralModeValue.Brake)
                                    .withInverted(InvertedValue.CounterClockwise_Positive))
                    .withCurrentLimits(new CurrentLimitsConfigs()
                                    .withStatorCurrentLimit(Amps.of(40))
                                    .withStatorCurrentLimitEnable(true)
                                    .withSupplyCurrentLimit(Amps.of(60))
                                    .withSupplyCurrentLimitEnable(true));
  }

  public static final class LEDConstants {
    /** The PWM port that the led bus is connected to the RIO on. */
    public static final int Port = 1;
    /** The length (in number of LED connections on the strip). */
    public static final int Length = 186;
    public static final int RightLength = 19;
    public static final int LeftLength = 36;
    public static final int MiddleLength = Length - RightLength - LeftLength;
    // RIGHT MIDDLE PART: 36
    // LEFT MIDDLE PART: 19
    // MIDDLE/Entire Robot: the rest
    public static final LEDPattern Off = LEDPattern.solid(Color.kBlack);
    public static final LEDPattern Red = LEDPattern.solid(Color.kRed);
    public static final LEDPattern Purple = LEDPattern.solid(Color.kPurple);

    public static final LEDPattern FlashingPurple = Purple.breathe(Seconds.of(0.5));

    public static final LEDPattern RainbowPattern = LEDPattern
                    .rainbow(255, 128);
    public static final LEDPattern ScrollRainbowPattern = RainbowPattern.scrollAtRelativeSpeed(
                    Percent.per(Second).of(120));
    }
}
