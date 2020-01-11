/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.OI;
import frc.robot.input.AttackThree.AttackThreeAxis;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A Default Drive commmand that passes joystick input to a TankDrive drivetrain.
 */
public class DefaultDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive m_drive;
  private final AttackThreeAxis yAxis = AttackThreeAxis.kY;
  private static OI oi;

  /**
   * Creates a new DefaultDrive.
   *
   * @param Drive The subsystem used by this command.
   */
  public DefaultDrive(Drive drive) {
    m_drive = drive;
    oi = OI.getInstance();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled. (Unused)
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.tankDrive(oi.getLeftStick().getAxis(yAxis), oi.getRightStick().getAxis(yAxis));
  }

  // Called once the command ends or is interrupted. (Unused)
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  //Default Command so will never finish running.
  @Override
  public boolean isFinished() {
    return false;
  }
}
