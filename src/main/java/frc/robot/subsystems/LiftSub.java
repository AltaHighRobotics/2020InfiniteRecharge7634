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

public class LiftSub extends SubsystemBase {
  private final Victor liftMotor;
  private final Victor trackMotor;

  public LiftSub() {
    liftMotor = new Victor(Constants.LIFT_MOTOR);
    trackMotor = new Victor(Constants.TRACK_MOTOR);
  }

  @Override
  public void periodic() {
  }

  public void liftWinchUp(){
    liftMotor.set(Constants.LIFT_UP);
  }

  public void liftWinchDown(){
    liftMotor.set(Constants.LIFT_DOWN);
  }

  public void liftWinchStop(){
    liftMotor.set(Constants.LIFT_STOP);
  }

  public void traaaaaaaaaaccccccccccccccckkkkkkkkkkkkkkiiiiiiiiinnnnnnnnnnnngggggggggg (double sped){
    trackMotor.set(sped);
  }

  public void stopTracking(){
    trackMotor.set(Constants.TRACK_STOP);
  }
}