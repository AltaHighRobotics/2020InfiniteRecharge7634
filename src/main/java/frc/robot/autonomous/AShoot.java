/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LemonShooterSub;
import frc.robot.subsystems.TubertSub;;

public class AShoot extends CommandBase {
  // getters
  private final TubertSub m_tubertSub;
  private final LemonShooterSub m_lemonShooterSub;
  private int aTubertUpTime;

  public AShoot(TubertSub tubeSub, LemonShooterSub lemonSub) {
    //setters
    m_lemonShooterSub = lemonSub;
    m_tubertSub = tubeSub;
    //subsystem dependencies
    addRequirements(m_tubertSub,m_lemonShooterSub);

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
    m_lemonShooterSub.startLemonShooterMotor();
    aTubertUpTime++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tubertSub.tubertStop();
    m_lemonShooterSub.stopLemonShooterMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (aTubertUpTime >= 200) {
      return true;
    }
    else{
      return false;
    }
  }

}