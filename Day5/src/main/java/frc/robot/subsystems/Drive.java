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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  private CANSparkMax motorA = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax motorZ = new CANSparkMax(2, MotorType.kBrushless);
  
  private CANEncoder encoder1 = new CANEncoder(motorA);
  private CANEncoder encoder2 = new CANEncoder(motorZ);

  private DifferentialDrive driverBase = new DifferentialDrive(motorA, motorZ);

  
  public Drive() {
    motorA = new CANSparkMax(0, MotorType.kBrushless);
    
    motorZ = new CANSparkMax(2, MotorType.kBrushless);
    
    encoder1 = new CANEncoder(motorA);
    encoder2 = new CANEncoder(motorZ);

  }

  //while loop is used to minimize delay
  public void goTenFeet() {
    while(encoder1.getPosition()*1024<(120/2*Math.PI*5)*1024 && encoder2.getPosition()*1024<(120/2*Math.PI*5)*1024) {    //constant doesn't work
    driverBase.tankDrive(1,1);
    }

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
