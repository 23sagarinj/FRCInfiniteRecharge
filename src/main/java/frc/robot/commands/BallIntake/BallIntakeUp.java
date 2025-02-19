/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/* 
 * Spins the intake roller until a ball has entered the ball intake. 
 * Once the ball is inside the ball intake, the conveyor motor will run
 * to move the ball towards the end of the conveyor.
 */
package frc.robot.commands.BallIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.TestingDashboard;
import frc.robot.subsystems.BallIntake;

public class BallIntakeUp extends CommandBase {
  private BallIntake m_ballIntake;
  private boolean m_finished = false;

  /**
   * Creates a new BallIntakeUp.
   */
   public BallIntakeUp() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(BallIntake.getInstance());
    m_ballIntake = BallIntake.getInstance();
  }

  public static void registerWithTestingDashboard() {
    BallIntake ballIntake = BallIntake.getInstance();
    BallIntakeUp cmd = new BallIntakeUp();
    TestingDashboard.getInstance().registerCommand(ballIntake, "Basic", cmd);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ballIntake.raiseIntake();
    m_finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_finished;
  }
}
