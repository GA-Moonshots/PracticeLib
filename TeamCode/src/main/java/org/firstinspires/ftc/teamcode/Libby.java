package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.PurePursuitCommand;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Libby extends CommandOpMode {

    // ATTENTION: found out that this mode is most likely for autonomous and not as our drivetrain, which is why
    // there is now a mecanumdrive op mode.

    private MecanumDrive mecanum;

    private Motor frontRightWheel;
    private Motor frontLeftWheel;
    private Motor backRightWheel;
    private Motor backLeftWheel;

    @Override
    public void initialize() {
        frontRightWheel = new Motor(hardwareMap, "frontRight");
        frontLeftWheel = new Motor(hardwareMap, "frontLeft");
        backRightWheel = new Motor(hardwareMap, "backRight");
        backLeftWheel = new Motor(hardwareMap, "backLeft");

        // Create our drive objects
        mecanum = new MecanumDrive(frontLeftWheel, frontRightWheel,
                backLeftWheel, backRightWheel);

        schedule();
    }
}
