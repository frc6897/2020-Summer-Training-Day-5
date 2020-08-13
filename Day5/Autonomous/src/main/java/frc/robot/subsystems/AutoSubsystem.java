/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Ultrasonic;


public class AutoSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private CANSparkMax motorR = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax motorL = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  private Ultrasonic sensor = new Ultrasonic(0);
  private CANEncoder encoder = new CANEncoder(motorR, motorL);
  public AutoSubsystem() {
motorR.follow(motorL);
  }
  public motorMove() {
    motorR.set(.5);
  }
  public motorStop() {
    motorR.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
