package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.LilPrince;
import org.firstinspires.ftc.teamcode.subsystems.Mecanum;

public class DriveCommand extends CommandBase {
    private final Mecanum drive;
    private GamepadEx player1;




    private double strafeSpeed;
    private double forwardSpeed;
    private double turnSpeed;

    public DriveCommand(Mecanum driveSubsystem, double strafeSpeed, double forwardSpeed, double turnSpeed) {
        this.drive = driveSubsystem;
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
        // Check control input
        strafeSpeed = player1.getLeftX();
        forwardSpeed = player1.getLeftY();
        turnSpeed = player1.getRightX();

        drive.driveRobot(strafeSpeed, forwardSpeed, turnSpeed);
    }

    public boolean isFinished() {
        // currently just a placeholder
        return false;
    }
}
