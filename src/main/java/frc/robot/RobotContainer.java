// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.KickerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SlapdownSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ShootCommand;

public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_adminController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);
  private final IndexerSubsystem indexer = new IndexerSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final KickerSubsystem kicker = new KickerSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final SlapdownSubsystem slapdown = new SlapdownSubsystem();
  
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureBindings();

    indexer.setDefaultCommand(indexer.stop());

    intake.setDefaultCommand(intake.stop());

    kicker.setDefaultCommand(kicker.stop());
  }

  private void configureBindings() {
    m_driverController.rightTrigger().whileTrue(new ShootCommand(shooter, indexer, kicker));
    m_driverController.leftTrigger().whileTrue(intake.start());

    m_adminController.povUp().onTrue(slapdown.retractSlapdownCommand());
    m_adminController.povDown().onTrue(slapdown.slapdownCommand());

    m_adminController.rightStick().onTrue(new RunCommand(() -> slapdown.resetSlapdownPosition(), slapdown));

    m_adminController.povLeft().whileTrue(Commands.startEnd(
                    () -> slapdown.setPower(0.36901),
                    () -> slapdown.stop(),
                    slapdown));
    m_adminController.povRight().whileTrue(Commands.startEnd(
                    () -> slapdown.setPower(-0.36901),
                    () -> slapdown.stop(),
                    slapdown));
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
