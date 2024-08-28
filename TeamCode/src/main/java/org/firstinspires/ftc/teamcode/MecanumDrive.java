package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive extends SubsystemBase {
    private final Motor frontRightWheel;
    private final Motor frontLeftWheel;
    private final Motor backRightWheel;
    private final Motor backLeftWheel;

    public MecanumDrive(final HardwareMap hMap) {
        frontRightWheel = new Motor(hMap, "frontRight");
        frontLeftWheel = new Motor(hMap, "frontLeft");
        backRightWheel = new Motor(hMap, "backRight");
        backLeftWheel = new Motor(hMap, "backLeft");
    }


}
