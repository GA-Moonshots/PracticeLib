package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.Mecanum;

public class LilPrince extends Robot {

    // INSTANCE VARIABLES
    public LinearOpMode opMode;
    public GamepadEx player1;
    public GamepadEx player2;

    // SUBSYSTEMS
    public Mecanum drive;




    /**
     * Welcome to the Command pattern. Here we assemble the robot and kick-off the command
     * @param opMode The selected operation mode
     */
    public LilPrince(LinearOpMode opMode) {
        this.opMode = opMode;
        player1 = new GamepadEx(opMode.gamepad1);
        player2 = new GamepadEx(opMode.gamepad2);
        initTele();
    }

    // OVERLOADED CONSTRUCTOR THAT RESPONDS TO AUTONOMOUS OPMODE USER QUERY
//    public LilPrince(LinearOpMode opMode, boolean isRed, boolean isLeft, boolean goForBoard) {
//        this.opMode = opMode;
//    }

    /**
     * Set teleOp's default commands and player control bindings
     */
    public void initTele() {

        drive = new Mecanum(new MecanumDrive(new Motor(opMode.hardwareMap, "frontLeft"),
                new Motor(opMode.hardwareMap, "frontRight"),
                new Motor(opMode.hardwareMap, "backLeft"),
                new Motor(opMode.hardwareMap, "backRight")));
        opMode.telemetry.addData("Mecanum Check:", true);
        opMode.telemetry.update();
        register(drive);

        drive.setDefaultCommand(new DriveCommand(drive,
                player1.getLeftX(), //this is kinda wierd and might be a source of errors
                player1.getLeftY(),
                player1.getRightX()
                ));

        opMode.telemetry.addData("Command Check:", true);
        opMode.telemetry.update();




        /*
                .__                                      ____
        ______  |  |  _____   ___.__.  ____ _______     /_   |
        \____ \ |  |  \__  \ <   |  |_/ __ \\_  __ \     |   |
        |  |_> >|  |__ / __ \_\___  |\  ___/ |  | \/     |   |
        |   __/ |____/(____  // ____| \___  >|__|        |___|
        |__|               \/ \/          \/
        */

        /*
                _                                    __
               (_ )                                /'__`\
         _ _    | |    _ _  _   _    __   _ __    (_)  ) )
        ( '_`\  | |  /'_` )( ) ( ) /'__`\( '__)      /' /
        | (_) ) | | ( (_| || (_) |(  ___/| |       /' /( )
        | ,__/'(___)`\__,_)`\__, |`\____)(_)      (_____/'
        | |                ( )_| |
        (_)                `\___/'
         */
    }


}