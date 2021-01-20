/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import frc.robot.subsystems.LimeLightSub;
import limelightvision.limelight.frc.ControlMode.LedMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ATargetingCommand extends CommandBase {
  private final LimeLightSub m_limeLightSub;
  private final DriveTrain m_driveTrain;
  private final int targetPipeline = 1;
  private final int lookPipeline = 0;
  private boolean endConditionXAxis = false;

  public ATargetingCommand(final LimeLightSub limeSub, final DriveTrain driveSub) {
    //getters
    m_limeLightSub = limeSub;
    m_driveTrain = driveSub;
    //subsystem dependencies
    addRequirements(m_limeLightSub);
  }

  @Override
  public void initialize() {
    //setters
    m_limeLightSub.getLimeLight().setPipeline(targetPipeline);
    m_limeLightSub.getLimeLight().setLEDMode(LedMode.kforceOn);
    Constants.TELEOP_DRIVE = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
    final double x = m_limeLightSub.getLimeLight().getdegRotationToTarget();
    final double y = m_limeLightSub.getLimeLight().getdegVerticalToTarget();
    if (x != 0 || y != 0){
      if (x > Constants.TARGET_AXIS){
        m_driveTrain.tTurnRight();
      }
      else if (x < -Constants.TARGET_AXIS){
        m_driveTrain.tTurnLeft();
      }
      else if (x < Constants.TARGET_AXIS && x > -Constants.TARGET_AXIS){
        if (y > Constants.TARGET_AXIS){
          m_driveTrain.tGoBackwards();
        }
        else if (y < -Constants.TARGET_AXIS){
          m_driveTrain.tGoForward();
        }
        else if (x < Constants.TARGET_AXIS && x > -Constants.TARGET_AXIS && y < Constants.TARGET_AXIS && y > -Constants.TARGET_AXIS){
          endConditionXAxis = true;
        }
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_driveTrain.tstopYeet();
    m_limeLightSub.getLimeLight().setLEDMode(LedMode.kforceOff);
    m_limeLightSub.getLimeLight().setPipeline(lookPipeline);
    Constants.TELEOP_DRIVE = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return endConditionXAxis;
  }
}