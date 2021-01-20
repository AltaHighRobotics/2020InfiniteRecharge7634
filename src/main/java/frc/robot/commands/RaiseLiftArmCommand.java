/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.      RaiseLiftArmCommand                                                         */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.StupidFrigginPistonSub;

public class RaiseLiftArmCommand extends CommandBase {
  //getters
  private final StupidFrigginPistonSub m_stupidFrigginPistonSub;

  public RaiseLiftArmCommand(StupidFrigginPistonSub poisonPistonSub) {
    //setters
    m_stupidFrigginPistonSub = poisonPistonSub;
    //subsystem dependencies
    addRequirements(m_stupidFrigginPistonSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("!!!WARNING PISTON IS ACTIVE!!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_stupidFrigginPistonSub.pistonOn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_stupidFrigginPistonSub.pistonOff();
    System.out.println("Piston is Inactive");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}