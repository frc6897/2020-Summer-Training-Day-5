/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DrivebaseSubsystem extends SubsystemBase {
  /**
   * Creates a new DrivebaseSubsystem.
   */

   private CANSparkMax leftMotor;
   private CANSparkMax rightMotor;
   private CANEncoder leftEncoder;
   private CANEncoder rightEncoder;

   private DifferentialDrive driveBase;

   private int ticks;

  public DrivebaseSubsystem() {

    leftMotor = new CANSparkMax(0, MotorType.kBrushless);
    rightMotor = new CANSparkMax(1, MotorType.kBrushless);
    leftEncoder = new CANEncoder(leftMotor);                     // declaring objects
    rightEncoder = new CANEncoder(rightMotor);
    driveBase = new DifferentialDrive(leftMotor, rightMotor);

    leftMotor.follow(rightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double leftSpeed, double rightSpeed, int counts) {
    if(rightEncoder.getPosition() * rightEncoder.getCountsPerRevolution() <= counts) {       //while encoder counts are below that for 10 feet, keep the motor running
      driveBase.tankDrive(leftSpeed, rightSpeed);
    } else if(rightEncoder.getPosition() * rightEncoder.getCountsPerRevolution() > counts) { //when encoder counts surpass that for 10 feet, kill the power to motors
      driveBase.tankDrive(Constants.MOTOR_OFF, Constants.MOTOR_OFF);
    }
  }

  public int calculateTicks(double distance) {
    ticks = (int)((distance)*(12) * (1/(2*Constants.WHEEL_RADIUS*Math.PI)) * (1024/1));
    return ticks;
  }

  public void stopMotors() {
    driveBase.tankDrive(Constants.MOTOR_OFF, Constants.MOTOR_OFF);
  }

}
