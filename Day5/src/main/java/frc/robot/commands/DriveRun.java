package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class DriveRun{
	public DriveRun()
	{
		addRequirements(RobotContainer.m_Drive);
	}
	@Override
	public void initialize() {
	}
	@Override
	public void execute() {
		RobotContainer.m_Drive.run();
	}
	@Override
	public void end(){
		RobotContainer.m_Drive.stop();
	}

}
