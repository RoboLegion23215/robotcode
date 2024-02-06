package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

/*
 * This OpMode illustrates the basics of AprilTag recognition and pose estimation,
 * including Java Builder structures for specifying Vision parameters.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list.
 */
@Autonomous(name = "ArmAuto", group = "Concept")
//@Disabled
public class ArmAuto extends LinearOpMode {

    private DcMotor leftFront;

    //motor_1 = leftFront
    private DcMotor leftBack;

    //motor_2 = leftBack

    private DcMotor rightFront;
    private DcMotor rightBack;

    private ColorSensor colorSensor;

    private Servo wrister;

    private DcMotor arm;

    private final double wristUp = 0.05;

    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera

    /**
     * The variable to store our instance of the AprilTag processor.
     */
    private AprilTagProcessor aprilTag;

    /**
     * The variable to store our instance of the vision portal.
     */
    private VisionPortal visionPortal;

    @Override
    public void runOpMode() {

        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F,0F,0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);

        // bPrevState and bCurrState represent the previous and current state of the button.
        boolean bPrevState = false;
        boolean bCurrState = false;

        // bLedOn represents the state of the LED.
        boolean bLedOn = true;

        // get a reference to our ColorSensor object.
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color");

        // Set the LED in the beginning
        colorSensor.enableLed(bLedOn);

        initAprilTag();

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        wrister = hardwareMap.get(Servo.class, "wrister");
        arm = hardwareMap.get(DcMotor.class, "arm");

        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the DS start button to be touched.
        telemetry.addData("DS preview on/off", "3 dots, Camera Stream");
        telemetry.addData(">", "Touch Play to start OpMode");
        // send the info back to driver station using telemetry function.
        telemetry.addData("LED", bLedOn ? "On" : "Off");
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());
        telemetry.addData("Hue", hsvValues[0]);
        telemetry.update();

        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {

                telemetryAprilTag();

                // Push telemetry to the Driver Station.
                telemetry.update();

                // Save CPU resources; can resume streaming when needed.
                if (gamepad1.dpad_down) {
                    visionPortal.stopStreaming();
                } else if (gamepad1.dpad_up) {
                    visionPortal.resumeStreaming();
                }

                // Share the CPU.
                sleep(20);
            }
        }

        // Save more CPU resources when camera is no longer needed.
        visionPortal.close();

    }   // end method runOpMode()

    /**
     * Initialize the AprilTag processor.
     */
    private void initAprilTag() {

        // Create the AprilTag processor.
        aprilTag = new AprilTagProcessor.Builder()
                //.setDrawAxes(false)
                //.setDrawCubeProjection(false)
                //.setDrawTagOutline(true)
                //.setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                //.setTagLibrary(AprilTagGameDatabase.getCenterStageTagLibrary())
                //.setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)

                // == CAMERA CALIBRATION ==
                // If you do not manually specify calibration parameters, the SDK will attempt
                // to load a predefined calibration for your camera.
                //.setLensIntrinsics(578.272, 578.272, 402.145, 221.506)

                // ... these parameters are fx, fy, cx, cy.

                .build();

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }

        // Choose a camera resolution. Not all cameras support all resolutions.
        //builder.setCameraResolution(new Size(640, 480));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        //builder.enableCameraMonitoring(true);

        // Set the stream format; MJPEG uses less bandwidth than default YUY2.
        //builder.setStreamFormat(VisionPortal.StreamFormat.YUY2);

        // Choose whether or not LiveView stops if no processors are enabled.
        // If set "true", monitor shows solid orange screen if no processors enabled.
        // If set "false", monitor shows camera view without annotations.
        //builder.setAutoStopLiveView(false);

        // Set and enable the processor.
        builder.addProcessor(aprilTag);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

        // Disable or re-enable the aprilTag processor at any time.
        //visionPortal.setProcessorEnabled(aprilTag, true);

    }   // end method initAprilTag()


    /**
     * Add telemetry about AprilTag detections.
     */
    private void telemetryAprilTag() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());
        AprilTagDetection x = null;

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }   // end for() loop

        // Add "key" information to telemetry
        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());

        telemetry.addData("Encoder value", arm.getCurrentPosition());
        telemetry.update();

        sleep(1000);

        wrister.setPosition(0.05);

        sleep(250);

        arm.setPower(0.25);

        sleep(1000);

        arm.setPower(0.0);

        //end of current auto

        /*leftFront.setPower(0.625);
        leftBack.setPower(0.625);
        rightFront.setPower(-0.625);
        rightBack.setPower(-0.625);

        sleep(700);

        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);

        leftBack.setPower(-0.55);

        rightBack.setPower(-0.55);

        leftFront.setPower(-0.55);

        rightFront.setPower(-0.55);


        sleep(1000);


        leftBack.setPower(0.0);

        rightBack.setPower(0.0);

        leftFront.setPower(0.0);

        rightFront.setPower(0.0);*/


        leftBack.setPower(0.0);

        rightBack.setPower(0.0);

        leftFront.setPower(0.0);

        rightFront.setPower(0.0);

        sleep(1000000000);

        leftBack.setPower(0.0);

        rightBack.setPower(0.0);

        leftFront.setPower(0.0);

        rightFront.setPower(0.0);


        /*if(colorSensor.blue() > 80){

            leftBack.setPower(0.55);

            rightBack.setPower(0.55);

            leftFront.setPower(0.55);

            rightFront.setPower(0.55);

            sleep(700);

            leftBack.setPower(0.0);

            rightBack.setPower(0.0);

            leftFront.setPower(0.0);

            rightFront.setPower(0.0);


            leftBack.setPower(0.55);

            rightBack.setPower(-0.55);

            leftFront.setPower(-0.55);

            rightFront.setPower(0.55);


            sleep(1400);


            leftBack.setPower(0.0);

            rightBack.setPower(0.0);

            leftFront.setPower(0.0);

            rightFront.setPower(0.0);

        } else if (colorSensor.blue() < 80){


            leftFront.setPower(-0.455);
            leftBack.setPower(-0.455);
            rightFront.setPower(0.455);
            rightBack.setPower(0.455);

            sleep(985);

            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);

        } else if(colorSensor.blue() > 94) {



        }*/


        /*if (x != null) {

            while (x.id == 1) {

                //Moves foward and scores pixel

                leftFront.setPower(0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Moves backwards to original starting point

                leftFront.setPower(-0.5);
                leftBack.setPower(-0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(-0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                // Turns toward the parking area

                leftFront.setPower(0.455);
                leftBack.setPower(0.455);
                rightFront.setPower(-0.455);
                rightBack.setPower(-0.455);

                sleep(985);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Drive towards parking area

                leftFront.setPower(0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0.5);

                sleep(3850);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Strafe left towards backboard

                leftFront.setPower(-0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(-0.5);

                sleep(1000);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                currentDetections = aprilTag.getDetections();

            }

            while (x.id == 2) {

                //Moves foward and scores pixel

                //Moves foward and scores pixel

                leftFront.setPower(0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Moves backwards to original starting point

                leftFront.setPower(-0.5);
                leftBack.setPower(-0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(-0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                // Turns toward the parking area

                leftFront.setPower(0.455);
                leftBack.setPower(0.455);
                rightFront.setPower(-0.455);
                rightBack.setPower(-0.455);

                sleep(985);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Strafe left towards backboard

                leftFront.setPower(-0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(-0.5);

                sleep(1000);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
                currentDetections = aprilTag.getDetections();

            }

            while (x.id == 3) {

                //Moves foward and scores pixel

                leftFront.setPower(0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                //Moves backwards to original starting point

                leftFront.setPower(-0.5);
                leftBack.setPower(-0.5);
                rightFront.setPower(-0.5);
                rightBack.setPower(-0.5);

                sleep(1200);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                // Turns toward the parking area

                leftFront.setPower(0.455);
                leftBack.setPower(0.455);
                rightFront.setPower(-0.455);
                rightBack.setPower(-0.455);

                sleep(985);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                leftFront.setPower(-0.5);
                leftBack.setPower(0.5);
                rightFront.setPower(0.5);
                rightBack.setPower(-0.5);

                sleep(1000);

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                currentDetections = aprilTag.getDetections();

            }

        }*/

    }   // end method telemetryAprilTag()

}   // end class
