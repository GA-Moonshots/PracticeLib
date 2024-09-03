package org.firstinspires.ftc.teamcode.util;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.LilPrince;

@TeleOp(name="TeleOp - Primary")
public class DriveyMcDriverson extends CommandOpMode {

    /**
     * Autonomous is over. It's time to drive. Forget RoadRunner's need to track our position
     */
    @Override
    public void initialize() {
        /*
         We build our robot. From here on out, we don't need this file. When we build the robot,
         all of our buttons are bound to commands and this class's parent, CommandOpMode, will
         continuously run any scheduled commands. We now slide into the WPILib style.
         */
        Robot m_robot = new LilPrince(this);
    }

}