package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Creating and Initializing our drivebase
        MecanumDrive mecanumDrive = new MecanumDrive(
                new Motor(hardwareMap, "frontLeft"),
                new Motor(hardwareMap, "frontRight"),
                new Motor(hardwareMap, "backLeft"),
                new Motor(hardwareMap, "backRight"));

        // Creating and Initializing our driver 1 gamepad
        GamepadEx driver_1 = new GamepadEx(gamepad1);

        waitForStart();

        while (!isStopRequested()) {
            mecanumDrive.driveRobotCentric(driver_1.getLeftX(),
                    driver_1.getLeftY(),
                    driver_1.getRightX(),
                    false);
        }
    }
}
