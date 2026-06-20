package frc.robot.subsystems;

import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.Constants.LEDConstants.*;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AddressableLEDBufferView;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    private final AddressableLED led;
    private final AddressableLEDBuffer buffer;
    private final AddressableLEDBufferView left;
    private final AddressableLEDBufferView middle;
    private final AddressableLEDBufferView right;

    public LEDSubsystem() {
        led = new AddressableLED(Port);
        buffer = new AddressableLEDBuffer(Length);
        led.setLength(Length);

        left = buffer.createView(0, 36);
        middle = buffer.createView(37, 166);
        right = buffer.createView(167, 185);

        led.start();
    }

    /**
     * Creates a command that runs a pattern on the entire LED strip.
     *
     * @param pattern the LED pattern to run
     */
    public Command runPattern(LEDPattern pattern) {
        return run(() -> pattern.applyTo(buffer));
    }

    public Command runPatternLeft(LEDPattern pattern) {
        return new RunCommand(() -> pattern.applyTo(left));
    }

    public Command runPatternMiddle(LEDPattern pattern) {
        return new RunCommand(() -> pattern.applyTo(middle));
    }

    public Command runPatternRight(LEDPattern pattern) {
        return new RunCommand(() -> pattern.applyTo(right));
    }

    public Command runAllPatterns(
            Supplier<LEDPattern> patternLeft,
            Supplier<LEDPattern> patternMiddle,
            Supplier<LEDPattern> patternRight) {
        return run(() -> {
            patternLeft.get().applyTo(left);
            patternMiddle.get().applyTo(middle);
            patternRight.get().applyTo(right);
        });
    }

    @Override
    public void periodic() {
        led.setData(buffer);
    }
}