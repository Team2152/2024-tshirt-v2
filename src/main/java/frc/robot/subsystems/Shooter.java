// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public final Barrel m_barrel_1;
  public final Barrel m_barrel_2;
  public final Barrel m_barrel_3;

  public Shooter() {
    m_barrel_1 = new Barrel(0);
    m_barrel_2 = new Barrel(1);
    m_barrel_3 = new Barrel(2);
    // Old list stuff that dont matter because it stupid/jk
    // List<Barrel> m_barrels = new ArrayList<>();
    // m_barrels.add(m_barrel_1);
    // m_barrels.add(m_barrel_2);
    // m_barrels.add(m_barrel_3);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

  public Barrel[] getArray() {
    Barrel[] m_barrels = {m_barrel_1, m_barrel_2, m_barrel_3}; 
    return m_barrels;
  }
}
