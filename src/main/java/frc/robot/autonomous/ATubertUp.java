/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TubertSub;;

public class ATubertUp extends CommandBase {
  //getters
  private final TubertSub m_tubertSub;
  private int aTubertUpTime;

  public ATubertUp(TubertSub tubeSub, XboxController Xbox) {
    //setters
    m_tubertSub = tubeSub;
    //subsystem dependencies
    addRequirements(m_tubertSub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    aTubertUpTime = 0; //sets the "timer" to 0 when first called
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_tubertSub.tubertUp();
    aTubertUpTime++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tubertSub.tubertStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (aTubertUpTime >= 7000) {
      return true;
    }
    else{
      return false;
    }
  }

}