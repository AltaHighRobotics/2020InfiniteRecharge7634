/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ATurnLeft extends CommandBase {
  //getters
  private final DriveTrain m_driveTrain;
  private int aTurnLeftTime;
  
  public ATurnLeft(DriveTrain driveSub) {
    //setters
    m_driveTrain = driveSub;
    //subsystem dependencies
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Constants.TELEOP_DRIVE = false;
    aTurnLeftTime = 0; //sets the "timer" to 0 when first called
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.turnLeft();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stopYeet();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (aTurnLeftTime >= 50) {
      return true;
    }
    else{
      return false;
    }
  }
}
