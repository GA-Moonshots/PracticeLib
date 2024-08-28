package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;

public class Libby extends CommandOpMode {
    MecanumDrive mecanumDrive;

    @Override
    public void initialize() {
        mecanumDrive = new MecanumDrive(hardwareMap);
        schedule();
    }
}
