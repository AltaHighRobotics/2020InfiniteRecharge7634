/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  private Victor driveTrainMotorLeft1;
  private Victor driveTrainMotorLeft2;
  private Victor driveTrainMotorRight1;
  private Victor driveTrainMotorRight2;
  private SpeedControllerGroup leftSideDrive;
  private SpeedControllerGroup rightSideDrive;
  private DifferentialDrive diffDrive;
  private UsbCamera aaaaaaaaaaaaCamera;
  
  public DriveTrain() {
    driveTrainMotorLeft1 = new Victor(Constants.DRIVE_TRAIN_MOTOR_LEFT_1);
    driveTrainMotorLeft2 = new Victor(Constants.DRIVE_TRAIN_MOTOR_LEFT_2);
    driveTrainMotorRight1 = new Victor(Constants.DRIVE_TRAIN_MOTOR_RIGHT_1);
    driveTrainMotorRight2 = new Victor(Constants.DRIVE_TRAIN_MOTOR_RIGHT_2);
    leftSideDrive = new SpeedControllerGroup(driveTrainMotorLeft1, driveTrainMotorLeft2);
    rightSideDrive = new SpeedControllerGroup(driveTrainMotorRight1, driveTrainMotorRight2);
    diffDrive = new DifferentialDrive(leftSideDrive, rightSideDrive);
    aaaaaaaaaaaaCamera = CameraServer.getInstance().startAutomaticCapture(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double speed, double turn) {
    diffDrive.arcadeDrive(-speed, turn);
  }

  public void tankDrive(double left, double right) {
    diffDrive.tankDrive(left, right);
  }

  public void tGoForward() {
    driveTrainMotorLeft1.set(Constants.TARGETING_SPEED);
    driveTrainMotorLeft2.set(Constants.TARGETING_SPEED);
    driveTrainMotorRight1.set(-Constants.TARGETING_SPEED);
    driveTrainMotorRight2.set(-Constants.TARGETING_SPEED);
  }

  public void tGoBackwards() {
    driveTrainMotorLeft1.set(-Constants.TARGETING_SPEED);
    driveTrainMotorLeft2.set(-Constants.TARGETING_SPEED);
    driveTrainMotorRight1.set(Constants.TARGETING_SPEED);
    driveTrainMotorRight2.set(Constants.TARGETING_SPEED);
  }

  public void tTurnLeft() {
    driveTrainMotorLeft1.set(-Constants.TARGETING_SPEED);
    driveTrainMotorLeft2.set(-Constants.TARGETING_SPEED);
    driveTrainMotorRight1.set(-Constants.TARGETING_SPEED);
    driveTrainMotorRight2.set(-Constants.TARGETING_SPEED);
  }

  public void tTurnRight() {
    driveTrainMotorLeft1.set(Constants.TARGETING_SPEED);
    driveTrainMotorLeft2.set(Constants.TARGETING_SPEED);
    driveTrainMotorRight1.set(Constants.TARGETING_SPEED);
    driveTrainMotorRight2.set(Constants.TARGETING_SPEED);
  }

  public void tstopYeet() {
    driveTrainMotorLeft1.set(Constants.DRIVE_STOP);
    driveTrainMotorLeft2.set(Constants.DRIVE_STOP);
    driveTrainMotorRight1.set(Constants.DRIVE_STOP);
    driveTrainMotorRight2.set(Constants.DRIVE_STOP);
  }

  public void goForward() {
    driveTrainMotorLeft1.set(Constants.DRIVE_SPEED);
    driveTrainMotorLeft2.set(Constants.DRIVE_SPEED);
    driveTrainMotorRight1.set(-Constants.DRIVE_SPEED);
    driveTrainMotorRight2.set(-Constants.DRIVE_SPEED);
  }

  public void goBackwards() {
    driveTrainMotorLeft1.set(Constants.NEG_DRIVE_SPEED);
    driveTrainMotorLeft2.set(Constants.NEG_DRIVE_SPEED);
    driveTrainMotorRight1.set(Constants.DRIVE_SPEED);
    driveTrainMotorRight2.set(Constants.DRIVE_SPEED);
  }

  public void turnLeft() {
    driveTrainMotorLeft1.set(Constants.NEG_DRIVE_SPEED);
    driveTrainMotorLeft2.set(Constants.NEG_DRIVE_SPEED);
    driveTrainMotorRight1.set(Constants.NEG_DRIVE_SPEED);
    driveTrainMotorRight2.set(Constants.NEG_DRIVE_SPEED);
  }

  public void turnRight() {
    driveTrainMotorLeft1.set(Constants.DRIVE_SPEED);
    driveTrainMotorLeft2.set(Constants.DRIVE_SPEED);
    driveTrainMotorRight1.set(Constants.DRIVE_SPEED);
    driveTrainMotorRight2.set(Constants.DRIVE_SPEED);
  }

  public void stopYeet() {
    driveTrainMotorLeft1.set(Constants.DRIVE_STOP);
    driveTrainMotorLeft2.set(Constants.DRIVE_STOP);
    driveTrainMotorRight1.set(Constants.DRIVE_STOP);
    driveTrainMotorRight2.set(Constants.DRIVE_STOP);
  }
}