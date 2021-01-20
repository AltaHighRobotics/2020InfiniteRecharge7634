/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LemonShooterSub extends SubsystemBase {
  private Victor lemonShooterMotor;

  public LemonShooterSub() {
    lemonShooterMotor = new Victor(Constants.LEMON_SHOOTER_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stopLemonShooterMotor() {
    lemonShooterMotor.set(Constants.STOP_LEMON);
  }

  public void startLemonShooterMotor() {
    lemonShooterMotor.set(Constants.START_LEMON);
    System.out.println("Lemon Shooter Inactive");
  }
}