/**makes the robot go backwards to get out of the way of others in autonomous */

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class A1 extends CommandBase {
  // getters
  private final DriveTrain m_driveTrain;
  private int a1Time;

  public A1(DriveTrain driveSub) {
    // setters
    m_driveTrain = driveSub;
    // subsystem dependencies
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    a1Time = 0; // sets the "timer" to 0 when first called
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.goForward();
    a1Time++; // increments a1Time every time it executes
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stopYeet();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (a1Time >= 160) { // checks to see if the program has executes 150 times
      return true;
    } else {
      return false;
    }
  }
}
