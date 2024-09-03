package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.LilPrince;

public class Mecanum extends SubsystemBase {

    // SUBSYSTEM ASSETS
    private final LilPrince m_robot;
    // MOTORS
    private final MotorEx leftFront, leftBack, rightFront, rightBack;
    //TODO: we need to get this subsystem working and give it the tasks.

    // Our default drive system that is robot centric
    // We should add field centric once we implement IMU
    public void driveRobot(double strafeSpeed, double forwardSpeed, double turnSpeed) {
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }


}
