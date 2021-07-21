// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Subsystem extends SubsystemBase {

  public CANSparkMax motor1;
  public CANEncoder encoder1;
  /** Creates a new Subsystem. */
  public Subsystem() {
    motor1 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    encoder1= motor1.getEncoder();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Spin (double speed){
    SmartDashboard.putNumber("motorpostion",encoder1.getPosition());
    motor1.set(speed);
  }
}
