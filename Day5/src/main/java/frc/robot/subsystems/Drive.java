package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;

public class Drive extends SubsystemBase{
	private CANSparkMax[] motors = new CANSparkMax[6];//west coast drivebase, 6 motors
	private CANEncoder[] enc = new CANEncoder[6];
	private Ultrasonic us = new Ultrasonic(Constants.US_PORT_1,Constants.US_PORT_2);
	private int encCt;
	public Drive(int distance){
		dist.setAutomaticMode(true);
		encCt = (12*distance)/(2*Constants.RD*Math.PI)*enc.getCountsPerRevolution();
		for(int i = 0;i<6;i++)
		{
			motors[i] = new CANSparkMax(Constants.MOTOR_PORT[i],CANSparkMaxLowLevel.MotorType.kBrushless);
			enc[i] = new CANEncoder(motors[i]);
		}
	}
	public void run(){
		enc.setPosition(0);
		while(enc[Constants.fLMotor].getPosition()<encCt)
		{
			motors[Constants.FLMOTOR].set(1);
			motors[Constants.FRMOtOR].set(1);
		}
	}
	public void stop(){
		motors[Constants.FLMOTOR].set(0);
		motors[Constants.FRMOTOR].set(0);
	}
}
