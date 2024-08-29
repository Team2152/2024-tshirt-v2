// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.BarrelConstants;
import frc.robot.Constants.DrivetrainConstants;


public class Drivetrain extends SubsystemBase {
  // Motor Variables
  private final WPI_TalonSRX m_frontLeft;
  private final WPI_TalonSRX m_frontRight;
  private final WPI_TalonSRX m_backLeft;
  private final WPI_TalonSRX m_backRight;

  public final DifferentialDrive m_drivetrain;
  
  public Drivetrain() {
    // Motor Variables
    m_backRight = new WPI_TalonSRX(DrivetrainConstants.backRightCAN);
    m_backRight.setInverted(true);
    m_frontRight = new WPI_TalonSRX(DrivetrainConstants.frontRightCAN);
    m_frontRight.setInverted(true);

    m_backLeft = new WPI_TalonSRX(DrivetrainConstants.backLeftCAN);
    m_frontLeft = new WPI_TalonSRX(DrivetrainConstants.frontLeftCAN);
    
    m_backLeft.follow(m_frontLeft);
    m_backRight.follow(m_frontRight);

    m_drivetrain = new DifferentialDrive(m_frontLeft, m_frontRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run 
  }
  // Set the drivetrain to move within a set limit (if applied)
  public void drive(double y, double x, boolean limiter) {
    //ternay command: (if condition) ? what to do if true : what to do if false
    double speed = limiter ? y / DrivetrainConstants.limiterMultiplier : y;
    double rot = limiter ? x / DrivetrainConstants.limiterMultiplier : x;
    
    m_drivetrain.arcadeDrive(speed, rot);
  }
// hey ryan before  u go can u commit please
  public Command driveCmd(DoubleSupplier y, DoubleSupplier x, BooleanSupplier limit) {
    return runOnce(() -> drive(y.getAsDouble(), x.getAsDouble(), limit.getAsBoolean()));
  }
}