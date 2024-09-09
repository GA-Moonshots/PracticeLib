package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.vision.AprilTag2dPipeline;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.LilPrince;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

public class Camera extends SubsystemBase {
    private LilPrince m_robot;

    public OpenCvCamera camera;

    public Camera (LilPrince robot) {
        m_robot = robot;

        int cameraMonitorViewId = m_robot.opMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", m_robot.opMode.hardwareMap.appContext.getPackageName());

        // Replace magic string w/hardware name file
        WebcamName webcamName = m_robot.opMode.hardwareMap.get(WebcamName.class, "Webcam 1");
        camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);;

        camera.setPipeline(new AprilTag2dPipeline());
    }

    public void open() {
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                // Usually this is where you'll want to start streaming from the camera (see section 4)
                camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }
            @Override
            public void onError(int errorCode)
            {
                /*
                 * This will be called if the camera could not be opened
                 */
            }
        });
    }
}