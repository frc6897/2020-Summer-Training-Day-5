/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class DriveToDistance extends CommandBase {
  /**
   * Creates a new DriveToDistance.
   */

   private int ticks = 0;

  public DriveToDistance() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DrivebaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ticks = RobotContainer.m_DrivebaseSubsystem.calculateTicks(10d);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_DrivebaseSubsystem.drive(Constants.MOTOR_ON, Constants.MOTOR_ON, this.ticks);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_DrivebaseSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
