package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSub;

public class DriveCommand extends CommandBase {
    private final MecanumDriveSub mc_d;

    private final double strafeSpeed;
    private final double forwardSpeed;
    private final double turnSpeed;

    public DriveCommand(MecanumDriveSub driveSubsystem, double strafeSpeed, double forwardSpeed, double turnSpeed) {
        this.mc_d = driveSubsystem;
        this.strafeSpeed = strafeSpeed;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        addRequirements(driveSubsystem);
    }

    // We call the command in our subsystem class to move our robot
    // this for know is not taking robt centric vs field centric into consideration
    // so we might need to rethink this
    @Override
    public void initialize(){}

    @Override
    public void execute() {
        mc_d.driveRobot(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public boolean isFinished() {
        // currently just a placeholder
        return false;
    }
}
