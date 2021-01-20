/** called at the end of autonomous to set the controls of the drive train back to the driver */

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class AEndCommand extends CommandBase {
  
  public AEndCommand() {
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Constants.TELEOP_DRIVE = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
