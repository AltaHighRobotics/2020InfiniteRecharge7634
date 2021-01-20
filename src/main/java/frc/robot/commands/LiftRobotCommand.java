/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.         LiftRobotCommand                                                      */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftSub;

public class LiftRobotCommand extends CommandBase {
  //getters
  private final LiftSub m_liftSub;

  public LiftRobotCommand(LiftSub liftSub) {
    //setters
    m_liftSub = liftSub;
    //subsystem dependencies
    addRequirements(m_liftSub);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Robot lift Active: Lifting Robot....");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_liftSub.liftWinchUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_liftSub.liftWinchStop();
    System.out.println("Robot lift Inactive");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
