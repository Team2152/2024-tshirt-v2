// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Barrel extends SubsystemBase {
  /** Creates a new Barrel. */
  private final Solenoid m_solenoid;
  private int sol_id;
  
  public Barrel(int solenoid_id) {
    m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, solenoid_id);
    sol_id = solenoid_id;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Set the state of the Barrel
  public Command set(Boolean state) {
    return runOnce(() -> {m_solenoid.set(state);System.out.println(sol_id);}); 
  }
  
}
