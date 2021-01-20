/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LemonShooterSub;

public class ALemonShooter extends CommandBase {
  //getters
  private final LemonShooterSub m_lemonShooterSub;

  public ALemonShooter(LemonShooterSub lemonSub, XboxController Xbox) {
    //setters
    m_lemonShooterSub = lemonSub;
    //subsystem dependencies
    addRequirements(m_lemonShooterSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lemonShooterSub.startLemonShooterMotor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lemonShooterSub.stopLemonShooterMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}