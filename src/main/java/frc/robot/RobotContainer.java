// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Subsystems.*;
import frc.robot.Commands.*;

public class RobotContainer {
  private CommandPS4Controller controller;

  private Intake intake;
  private Intake_Commands intake_Commands;

  public RobotContainer() {
    controller = new CommandPS4Controller(0);

    intake = new Intake();
    intake_Commands = new Intake_Commands(intake);

    configureBindings();
  }

  private void configureBindings() {
    controller.R2()
    .onTrue(intake_Commands.runForward())
    .onFalse(intake_Commands.stop());

    controller.L2()
    .onTrue(intake_Commands.runBackward())
    .onFalse(intake_Commands.stop());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
