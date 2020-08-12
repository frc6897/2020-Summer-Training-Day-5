/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  private CANSparkMax motorA = new CANSparkMax(0, MotorType.kBrushless);
  
  
  private CANSparkMax motorY = new CANSparkMax(2, MotorType.kBrushless);
  
  
  private CANEncoder encoder1 = new CANEncoder(motorA);
  private CANEncoder encoder2 = new CANEncoder(motorY);

  
  public Drive() {
    motorA = new CANSparkMax(0, MotorType.kBrushless);
    
    motorY = new CANSparkMax(2, MotorType.kBrushless);
    
    encoder1 = new CANEncoder(motorA);
    encoder2 = new CANEncoder(motorY);

  }

  public void goTenFeet() {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
