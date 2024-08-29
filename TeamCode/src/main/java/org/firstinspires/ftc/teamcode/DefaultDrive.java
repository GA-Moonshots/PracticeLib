package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

public class DefaultDrive extends CommandBase {
    private final DriveSubsystem driveSubsystem;

    private final double strafeSpeed;
    private final double forwardSpeed;
    private final double turnSpeed;

    public DefaultDrive(DriveSubsystem driveSubsystem, double strafeSpeed, double forwardSpeed, double turnSpeed) {
        this.driveSubsystem = driveSubsystem;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        addRequirements(driveSubsystem);
    }

    // We call the command in our subsystem class to move our robot
    // this for know is not taking robt centric vs field centric into consideration
    // so we might need to rethink this
    @Override
    public void execute() {
        driveSubsystem.driveRobot(strafeSpeed, forwardSpeed, turnSpeed);
    }

}
