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
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class AutoSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private CANSparkMax motorR = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax motorL = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  private Ultrasonic sensor = new Ultrasonic(0);
  private CANEncoder encoderR = new CANEncoder(motorR);
  private CANEncoder encoderL = new CANEncoder(motorL);
  private DifferentialDrive driveBase = new DifferentialDrive(motorL, motorR);
 

  public AutoSubsystem() {
motorR.follow(motorL);
sensor.setAutomaticMode(true);
driveContainer.setDefaultCommand(new arcadeDrive());
  }
  public motorMove() {
    motorL.set(.5);
  }
  public motorStop() {
    motorL.set(0);
  }
  public wheelRadius() {
    int radius = 5;
  }
  public distanceToGoal() {
    double distance = 10d;
  }
  public calculateCounts(double distance) {
counts = (int)(distance)*(12)*(1/(2*wheelRadius()*Math.PI))*(1024/1);
return counts;
  }
  public driving(double leftSpeed, double rightSpeed, int counts) {
    if (encoderL.getPosition()*encoderL.getCountsPerRevolution() <= counts) {
      driveBase.tankDrive(leftSpeed, rightSpeed);
    } else if (encoderL.getPosition()*encoderL.getCountsPerRevolution() > counts) {
      driveBase.tankDrive(motorStop(motorL), motorStop(motorL));
    }
  }
  public void driveDistance() {
    driving( leftSpeed, rightSpeed, calculateCounts(distanceToGoal()));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}




