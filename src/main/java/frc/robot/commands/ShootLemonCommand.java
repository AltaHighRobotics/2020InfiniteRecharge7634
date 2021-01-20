/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LemonShooterSub;
import frc.robot.subsystems.TubertSub;

public class ShootLemonCommand extends CommandBase {
  // getters
  private final TubertSub m_tubertSub;
  private final LemonShooterSub m_lemonShooterSub;

  public ShootLemonCommand(TubertSub tubeSub, LemonShooterSub lemonSub) {
    //setters
    m_lemonShooterSub = lemonSub;
    m_tubertSub = tubeSub;
    //subsystem dependencies
    addRequirements(m_tubertSub,m_lemonShooterSub);

  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Lemon Shooter Active");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_tubertSub.tubertUp();
    m_lemonShooterSub.startLemonShooterMotor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tubertSub.tubertStop();
    m_lemonShooterSub.stopLemonShooterMotor();
    System.out.println("Lemon Shooter InActive");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}