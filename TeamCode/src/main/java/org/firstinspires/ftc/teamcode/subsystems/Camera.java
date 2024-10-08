package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.vision.AprilTag2dPipeline;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.LilPrince;
import org.firstinspires.ftc.teamcode.util.HardwareNames;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import com.acmerobotics.dashboard.FtcDashboard;

public class Camera {
    // Instance variables
    private boolean isAprilTag = true;

    // Hardware
    private LilPrince m_robot;
    private OpenCvCamera camera;

    public Camera (LilPrince robot, Telemetry telemetry) {
        telemetry.addData("Camera Working", true);
        telemetry.update();

        // We instantiate the robot
        m_robot = robot;

        // Camera Instantiation procedures
        int cameraMonitorViewId = m_robot.opMode.hardwareMap.appContext.getResources().
                getIdentifier("cameraMonitorViewId", "id",
                        m_robot.opMode.hardwareMap.appContext.getPackageName());

        WebcamName webcamName = m_robot.opMode.hardwareMap.get(WebcamName.class, HardwareNames.WEBCAM_NAME);
        camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);;

        // FTC Dashboard Camera Set up stuff
        FtcDashboard.getInstance().startCameraStream(camera, 60);

        // Checks which pipeline we will use
        if(isAprilTag) {
            //Setting our pipeline to the camera
            camera.setPipeline(new AprilTag2dPipeline());
        }

        // Opening the camera
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

    // Method to determine which pipeline we will use
    public void AprilTagPipelineSelected(boolean state) {
        isAprilTag = state;
    }
}