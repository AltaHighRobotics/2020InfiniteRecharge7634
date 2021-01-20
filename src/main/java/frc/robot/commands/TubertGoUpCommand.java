/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TubertSub;;

public class TubertGoUpCommand extends CommandBase {
  //getters
  private final TubertSub m_tubertSub;

  public TubertGoUpCommand(TubertSub tubeSub, XboxController Xbox) {
    //setters
    m_tubertSub = tubeSub;
    //subsystem dependencies
    addRequirements(m_tubertSub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Turbert On");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_tubertSub.tubertUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tubertSub.tubertStop();
    System.out.println("Tubert Off");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}