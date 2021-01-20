/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
  private final Victor intakeMotor;
  private final Solenoid intakeSolenoid;

  public IntakeSub() {
    intakeMotor = new Victor(Constants.INTAKE_MOTOR);
    intakeSolenoid = new Solenoid(Constants.INTAKE_SOLENOID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakePistonOn(){
    intakeSolenoid.set(true);
  }

  public void intakePistonOff(){
    intakeSolenoid.set(true);
  }

  public void intakeMotorIsOn(){
    intakeMotor.set(Constants.INTAKE_MOTOR_SPEED);
  }

  public void intakeMotorIsOff(){
    intakeMotor.set(Constants.INTAKE_MOTOR_STOP_SPEED);
  }

  public void intakeMotorIsReversed(){
    intakeMotor.set(-Constants.INTAKE_MOTOR_SPEED);
  }
}