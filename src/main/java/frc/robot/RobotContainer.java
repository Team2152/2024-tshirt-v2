// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.BarrelSelector; //idk
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  private Shooter m_shooter;
  private CommandXboxController m_driverController; 
  private BarrelSelector m_barrelSelector;

  public RobotContainer() {
    m_shooter = new Shooter();
    m_barrelSelector = new BarrelSelector(m_shooter);
    m_driverController = new CommandXboxController(0);
    
    configureBindings();
    
  }

  private void configureBindings() {
    // On D-Pad Up (povUp), Increment Barrel Selection.
    m_driverController.povUp() 
      .onFalse(m_barrelSelector.up());
    // On D-Pad Down (povDown), Decrement Barrel Selection.
    m_driverController.povDown() 
      .onFalse(m_barrelSelector.down());
    // On GamePad A, Fire the selected Barrel.
    m_driverController.a()
      .onFalse(m_barrelSelector.fireCurBarrel());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured!!!!!!!!!!!!!"); 
  }
}