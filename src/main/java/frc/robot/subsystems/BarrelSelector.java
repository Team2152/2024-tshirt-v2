// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.BarrelConstants;

public class BarrelSelector extends SubsystemBase {
  /** Creates a new BarrelSelector. */
  // The currently selected barrel. Not the Barrel ID. :(
  public int cur_barrel;
  private Barrel[] m_barrels;
  
  public BarrelSelector(Shooter shooter) {
    cur_barrel = 0;
    m_barrels = shooter.getArray();
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("Current Barrel", cur_barrel); 
  }
  // Increment the selected barrel.
  public Command up() {
    // Attempts to Increment over the maximum amount (2) will loop back to the start (0).
    return runOnce(
      () -> {
        if (cur_barrel == 2) {
          cur_barrel = 0;
        } else {
          cur_barrel++;
        }
      }
    );
  }
  // Decrement the selected barrel.
  public Command down() {
    // Attempts to Decrement over the minimum amount (0) will loop back to the start (2).
    return runOnce(
      () -> {
        if (cur_barrel == 0) {
          cur_barrel = 2;
        } else {
          cur_barrel--;
        }
      }
    );
  }
  // Fire the selected barrel. Hopefully. Please, please, please.
  public Command fireCurBarrel() {
    return new SequentialCommandGroup(
      runOnce(() -> m_barrels[cur_barrel].set(true)),
      new WaitCommand(BarrelConstants.barrelWaitTime),
      runOnce(() -> m_barrels[cur_barrel].set(false))
    );
  }
}
