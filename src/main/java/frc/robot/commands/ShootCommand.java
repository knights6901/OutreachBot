package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.KickerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
    private final ShooterSubsystem shooter;
    private final IndexerSubsystem indexer;
    private final KickerSubsystem kicker;

    public ShootCommand(ShooterSubsystem shooter, IndexerSubsystem indexer, KickerSubsystem kicker) {
        this.shooter = shooter;
        this.indexer = indexer;
        this.kicker = kicker;

        addRequirements(shooter, indexer, kicker);
    }

    @Override
    public void initialize() {
        shooter.start();
        indexer.start();
        kicker.start();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
        indexer.stop();
        kicker.stop();
    }

    @Override
    public boolean isFinished() {   
        return false;
    }
}