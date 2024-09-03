package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DefaultDrive;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class Libby extends CommandOpMode {
    // ATTENTION: found out that this mode is most likely for autonomous and not as our drivetrain, which is why
    // there is now a mecanumdrive op mode.
    private GamepadEx driver_1;
    private DriveSubsystem driveSubsystem;
    private DefaultDrive defaultDrive;

    private  MecanumDrive mecanumDrive;

    @Override
    public void initialize() {
        // TODO: we eventually want to add a second controller
        //  for the arm and a button to switch bewteen field centric and robot centric steering
        //  for this, however, we need to have the IMU and driver_2 control, we should do this
        //  AFTER we confirm the robot is working normally

        telemetry.addData("elapsedTime", 1);
        telemetry.update();

        // We initialize all of our hardware and controllers
        driver_1 = new GamepadEx(gamepad1);

        mecanumDrive = new MecanumDrive(
                new Motor(hardwareMap, "frontLeft"),
                new Motor(hardwareMap, "frontRight"),
                new Motor(hardwareMap, "backLeft"),
                new Motor(hardwareMap, "backRight")
        );

        driveSubsystem = new DriveSubsystem(mecanumDrive);

        // We define our commands here
        // basic robot-centric movement command
        defaultDrive = new DefaultDrive(driveSubsystem,
                driver_1.getLeftX(), //this is kinda wierd and might be a source of errors
                driver_1.getLeftY(),
                driver_1.getRightX()
        );

        // once we register our drivesystem, we can assign it a default command so that
        // it gets run by the command scheduler
        // https://docs.ftclib.org/ftclib/command-base/command-system/command-scheduler#step-4-schedule-default-commands

        run();
        driveSubsystem.setDefaultCommand(new DefaultDrive(driveSubsystem,
                driver_1.getLeftX(), //this is kinda wierd and might be a source of errors
                driver_1.getLeftY(),
                driver_1.getRightX()
        ));
        register(driveSubsystem);


        schedule(new RunCommand(telemetry::update));
    }


}
