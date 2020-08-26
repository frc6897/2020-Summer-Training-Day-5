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
 
public class DriveSubsystem extends SubsystemBase {
 /**
  * Creates a new DriveSubsystem.
  */
 private CANSparkMax motor1; 
 private CANSparkMax motor2;
  private CANEncoder encoder1;
 private CANEncoder encoder2;
 
 private DifferentialDrive driveBase = new DifferentialDrive(motor1, motor2);
  private Constants Constant = new Constants();
 
  public Drive() {
   motor1 = new CANSparkMax(0, MotorType.kBrushless);
  
   motor2 = new CANSparkMax(2, MotorType.kBrushless);
  
   encoder1 = new CANEncoder(motor1);  
   encoder2 = new CANEncoder(motor2);
 
 }
 
 public void drive() {
   while(encoder1.getPosition()*1024 <120/2*Math.PI*WHEEL_RADIUS*1024
    && encoder2.getPosition()*1024<120/2*Math.PI*WHEEL_RADIUS*1024) {   
   driveBase.tankDrive(1,1);
   }
   stop();   
}
 public void stop() {
   driveBase.tankDrive(0,0);
 }
 @Override
 public void periodic() {
   // This method will be called once per scheduler run
 }
}

