// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.KickerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);
  private final IndexerSubsystem indexer = new IndexerSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final KickerSubsystem kicker = new KickerSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureBindings();
    indexer.setDefaultCommand(new RunCommand(() -> indexer.motor.set(0), indexer));

    intake.setDefaultCommand(new RunCommand(() -> intake.intakeMotor.set(0), intake));

    kicker.setDefaultCommand(new RunCommand(() -> kicker.kickerMotor.set(0), kicker));
  }
 
  private void configureBindings() {
    // TODO: Run shooter at 20 RPS on right trigger
      m_driverController.rightTrigger().whileTrue(new RunCommand(() -> shooter.setShooterSpeed(20), shooter));
    // TODO: Run intake at 70% power on left trigger
     m_driverController.y().whileTrue(indexer.start());
    // TODO: Run indexer at 70% power on y
    
    // TODO: Run kicker at 20% power on a
     m_driverController.a().whileTrue(kicker.start());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
