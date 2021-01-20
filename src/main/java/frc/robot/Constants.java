/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // ----------RoboRio Ports---------- \\

    public static final int DRIVE_TRAIN_MOTOR_LEFT_1 = 0;
    public static final int DRIVE_TRAIN_MOTOR_LEFT_2 = 1;
    public static final int DRIVE_TRAIN_MOTOR_RIGHT_1 = 2;
    public static final int DRIVE_TRAIN_MOTOR_RIGHT_2 = 3;

    public static final int LEMON_SHOOTER_MOTOR = 4;
    public static final int TUBERT_MOTOR = 5;

    public static final int LIFT_MOTOR = 6;
    public static final int TRACK_MOTOR = 7;
    public static final int INTAKE_MOTOR = 8;
    
    public static final int COMPRESSOR_PORT = 0; // Not a Rio Port but whatever ¯\_(ツ)_/¯
    public static final int SOLENOID = 0; // Alse not a Rio Port
    public static final int INTAKE_SOLENOID = 1;
     
    // ----------Controller---------- \\

    public static final int DRIVER_CONTROLLER_1 = 0;
    public static final int DRIVER_CONTROLLER_2 = 1;

    public static final int Right_STICK_Y = 5;
    public static final int RIGHT_STICK_X = 4;
    public static final int LEFT_STICK_Y = 2;
    public static final int LEFT_STICK_X = 1;
 
    public static final int XBOX_A_BUTTON = 1; // Makes Tubert motor go up
    public static final int XBOX_B_BUTTON = 2;
    public static final int XBOX_X_BUTTON = 3;
    public static final int XBOX_Y_BUTTON = 4;
 
    public static final int XBOX_LEFT_BUMPER = 5; // Toggles lemon shooter motor
    public static final int XBOX_RIGHT_BUMPER = 6;
 
    public static final int XBOX_LEFT_STICK_BUTTON = 9;
    public static final int XBOX_RIGHT_STICK_BUTTON = 10;

    public static final int GUIDARAXIS = 0;

    // ----------Robot Constants---------- \\

    public static final double START_LEMON = -0.9;
    public static final double STOP_LEMON = 0;

    public static final double TURN_SPEED = 0.3;
    public static final double DRIVE_SPEED = 0.3;
    public static final double DRIVE_STOP = 0;
    public static final double NEG_DRIVE_SPEED = -0.7;
    
    public static final double TARGETING_SPEED = 0.3;
    public static final double TARGET_AXIS = 0.5;

    public static final double TUBERT_UP = -0.5;
    public static final double TUBERT_REVERSE = 0.5;
    public static final double TUBERT_STOP = 0;
    
    public static final double LIFT_UP = -0.9;
    public static final double LIFT_DOWN = 0.9;
    public static final double LIFT_STOP = 0;

    public static final double TRACK_SPEED_LEFT = 0.7;
    public static final double TRACK_SPEED_RIGHT = -0.7;   
    public static final double TRACK_STOP = 0;
    public static final double TRACKING_SPEED = 1;

    public static final double TELEOP_SPEED = 0.8;
    
	public static final double INTAKE_MOTOR_SPEED = 1;
	public static final double INTAKE_MOTOR_STOP_SPEED = 0;

    //booleans
    public static boolean TELEOP_DRIVE = true;
    public static boolean DEFENSIVE_DRIVE = false;
    public static boolean AUTO_BOOL = false;   
}