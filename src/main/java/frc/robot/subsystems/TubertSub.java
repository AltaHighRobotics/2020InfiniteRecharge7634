package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Victor;

public class TubertSub extends SubsystemBase {
  private Victor tubertMotor;

  public TubertSub() {
    tubertMotor = new Victor(Constants.TUBERT_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tubertUp() {
    tubertMotor.set(-Constants.TUBERT_UP);
  }

  public void tubertStop() {
    tubertMotor.set(Constants.TUBERT_STOP);
  }

public void tubertDown() {
  tubertMotor.set(Constants.TUBERT_UP);
}

}