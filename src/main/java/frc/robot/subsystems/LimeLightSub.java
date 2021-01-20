/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import limelightvision.limelight.frc.LimeLight;
public class LimeLightSub extends SubsystemBase {
  public LimeLight limeLight;

  public LimeLightSub() {
    limeLight = new LimeLight();
  }

  @Override
  public void periodic() {
  }
  public LimeLight getLimeLight(){
    return limeLight;
}

}