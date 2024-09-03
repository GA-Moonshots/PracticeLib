package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;

public class DriveSubsystem extends SubsystemBase {
    private final MecanumDrive mecanumDrive;

    public DriveSubsystem(MecanumDrive mecanumDrive) {
        this.mecanumDrive = mecanumDrive;
    }

    // Our default drive system that is robot centric
    // We should add field centric once we implement IMU
    public void driveRobot(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        mecanumDrive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

    @Override
    public void periodic() {
        super.periodic();
        CommandScheduler.getInstance().run();
    }
}
