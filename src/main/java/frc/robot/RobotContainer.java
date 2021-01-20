/**
 * Hey homie, I know at some point ur going to be debugging this but like bruv you totes
 * got this my bro. you just need to make sure you stay positive and start at the robot 
 * container and then the subsystem and then the command. you friggin got this bro!
 * -Past Cracker
*/
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DefenseDriveToggleCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.LiftRobotCommand;
import frc.robot.commands.LowerRobotCommand;
import frc.robot.commands.RaiseLiftArmCommand;
import frc.robot.commands.SecondaryIntakeCommand;
import frc.robot.commands.ShootLemonCommand;
import frc.robot.commands.TargetingCommand;
import frc.robot.commands.TrackingCommand;
import frc.robot.commands.TubertGoDownCommand;
import frc.robot.commands.TubertGoUpCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.LemonShooterSub;
import frc.robot.subsystems.LiftSub;
import frc.robot.subsystems.LimeLightSub;
import frc.robot.subsystems.StupidFrigginPistonSub;
import frc.robot.subsystems.TubertSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autonomous.*;

public class RobotContainer {
  // ----------Define them here dumb dumb---------- \\
  private final XboxController drivController = new XboxController(Constants.DRIVER_CONTROLLER_1);
  private final XboxController climbController = new XboxController(Constants.DRIVER_CONTROLLER_2);

  //subsystems
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final LimeLightSub m_limeLightSub = new LimeLightSub();
  private final TubertSub m_tubertSub = new TubertSub();
  private final LemonShooterSub m_lemonShooterSub = new LemonShooterSub();
  private final LiftSub m_liftSub = new LiftSub();
  private final StupidFrigginPistonSub m_stupidFrigginPistonSub = new StupidFrigginPistonSub();
  private final IntakeSub m_intakeSub = new IntakeSub();

  //commands
  private final DefenseDriveToggleCommand m_defenseDriveToggleCommand = new DefenseDriveToggleCommand();

  private final DriveCommand m_driveCommand = new DriveCommand(m_driveTrain, drivController);

  private final TargetingCommand m_targetingCommand = new TargetingCommand(m_limeLightSub, m_driveTrain);
  
  private final TubertGoUpCommand m_tubertGoUpCommand = new TubertGoUpCommand(m_tubertSub, drivController);
  private final TubertGoDownCommand m_tubertGoDownCommand = new TubertGoDownCommand(m_tubertSub, drivController);

  private final ShootLemonCommand m_shootLemonCommand = new ShootLemonCommand(m_tubertSub, m_lemonShooterSub);

  private final LiftRobotCommand m_liftRobotCommand = new LiftRobotCommand(m_liftSub);
  
  private final LowerRobotCommand m_lowerRobotCommand = new LowerRobotCommand(m_liftSub);
  private final TrackingCommand m_trackingCommand = new TrackingCommand(m_liftSub, climbController);

  private final RaiseLiftArmCommand m_raiseLiftArmCommand = new RaiseLiftArmCommand(m_stupidFrigginPistonSub);

  private final SecondaryIntakeCommand m_secondaryIntakeCommand = new SecondaryIntakeCommand(m_intakeSub);

  private final A1 m_a1 = new A1(m_driveTrain); // Autonomous
  private final ATurnRight m_aTurnRight = new ATurnRight(m_driveTrain);
  private final ATurnLeft m_aTurnLeft = new ATurnLeft(m_driveTrain);
  private final ATargetingCommand m_aTargetingCommand = new ATargetingCommand(m_limeLightSub, m_driveTrain);
  private final AEndCommand m_aEndCommand = new AEndCommand();
  private final ALemonShooter m_aLemonShooter = new ALemonShooter(m_lemonShooterSub, drivController);
  private final ATubertUp m_aTubertUp = new ATubertUp(m_tubertSub, drivController);
  private final A2 m_a2 = new A2(m_driveTrain);
  private final AShoot m_aShoot = new AShoot(m_tubertSub, m_lemonShooterSub);

  //private final ParallelRaceGroup m_aTubeShoot = new ParallelRaceGroup(m_aTubertUp,m_aLemonShooter);
  //private final SequentialCommandGroup m_auto1 = new SequentialCommandGroup(m_aTargetingCommand, m_aShoot, m_a1, m_aEndCommand);
  private final SequentialCommandGroup m_auto2 = new SequentialCommandGroup(m_aShoot, m_a1, m_aEndCommand);
  //private final SequentialCommandGroup m_auto3 = new SequentialCommandGroup(m_a2, m_aTurnLeft, m_aTargetingCommand, m_aShoot, m_a1, m_aEndCommand);
  // Button Bindings
  public RobotContainer() {
    // Configure the button 
    
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_driveTrain, m_driveCommand);
    CommandScheduler.getInstance().setDefaultCommand(m_liftSub, m_trackingCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // ----------Button Declarations----------\\
    
    //driving controller
    final JoystickButton tubertButton = new JoystickButton(drivController, Constants.XBOX_LEFT_BUMPER);
    final JoystickButton shootLemonButton = new JoystickButton(drivController, Constants.XBOX_RIGHT_BUMPER);
    //final JoystickButton targetingButton = new JoystickButton(drivController, Constants.XBOX_A_BUTTON);
    final JoystickButton tubertDownButton = new JoystickButton(drivController, Constants.XBOX_B_BUTTON);
    final JoystickButton intakeButton = new JoystickButton(drivController, Constants.XBOX_Y_BUTTON);
    //final JoystickButton defenseButton = new JoystickButton(drivController, Constants.XBOX_Y_BUTTON);
    
    //climbing controller
    final JoystickButton raiseArmButton = new JoystickButton(climbController, Constants.XBOX_Y_BUTTON);
    final JoystickButton liftRobotButton = new JoystickButton(climbController, Constants.XBOX_A_BUTTON);
    final JoystickButton lowerRobotButton = new JoystickButton(climbController, Constants.XBOX_X_BUTTON);

    // ----------Comand Scheduler----------\\
    
    //driving controller                       
    tubertButton.whenPressed(m_tubertGoUpCommand);
    shootLemonButton.toggleWhenPressed(m_shootLemonCommand);
    //targetingButton.toggleWhenPressed(m_targetingCommand);
    tubertDownButton.whenPressed(m_tubertGoDownCommand);
    intakeButton.whenPressed(m_secondaryIntakeCommand);
    //defenseButton.toggleWhenPressed(m_defenseDriveToggleCommand);

    //climbing controller
    raiseArmButton.toggleWhenPressed(m_raiseLiftArmCommand);
    liftRobotButton.whileHeld(m_liftRobotCommand);
    lowerRobotButton.whileHeld(m_lowerRobotCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_auto2;
    // 1 is Left
    // 2 is Middle
    // 3 is Right
  }
}