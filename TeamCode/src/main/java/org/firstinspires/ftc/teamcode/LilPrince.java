package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSub;

public class LilPrince extends Robot {

    // INSTANCE VARIABLES
    public LinearOpMode opMode;
    public GamepadEx player1;
    public GamepadEx player2;

    // SUBSYSTEMS
    public MecanumDriveSub drive;

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
        drive = new MecanumDriveSub(new MecanumDrive(new Motor(opMode.hardwareMap, "frontLeft"),
                new Motor(opMode.hardwareMap, "frontRight"),
                new Motor(opMode.hardwareMap, "backLeft"),
                new Motor(opMode.hardwareMap, "backRight")));



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