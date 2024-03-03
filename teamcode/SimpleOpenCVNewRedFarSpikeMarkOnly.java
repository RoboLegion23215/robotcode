package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name = "OpenCV New Red Far", group = "Concept")
public class SimpleOpenCVNewRedFarSpikeMarkOnly extends OpMode {
    private DrawRectangleProcessorFar drawRectangleProcessorFar;
    private VisionPortal visionPortal;


    @Override
    public void init() {
        drawRectangleProcessorFar = new DrawRectangleProcessorFar();
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam 1"), drawRectangleProcessorFar);
        DrawRectangleProcessorFar.Selected s = drawRectangleProcessorFar.getSelection();

        telemetry.addData("ColorSat", s.toString());
        telemetry.update();
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        //visionPortal.stopStreaming();
    }


    @Override
    public void loop() {
        try {


            DrawRectangleProcessorFar.Selected selection = drawRectangleProcessorFar.getSelection();
            MoveRobotEncoder mr = new MoveRobotEncoder(hardwareMap);

            telemetry.addData("Identified", drawRectangleProcessorFar.getSelection());
            telemetry.addData("Left", drawRectangleProcessorFar.satRectLeft);
            telemetry.addData("Right", drawRectangleProcessorFar.satRectRight);
            telemetry.addData("Middle", drawRectangleProcessorFar.satRectMiddle);

            telemetry.update();

            sleep(1000);
            selection = drawRectangleProcessorFar.getSelection();
            telemetry.addData("Identified", drawRectangleProcessorFar.getSelection());
            telemetry.addData("Left", drawRectangleProcessorFar.satRectLeft);
            telemetry.addData("Right", drawRectangleProcessorFar.satRectRight);
            telemetry.addData("Middle", drawRectangleProcessorFar.satRectMiddle);

            telemetry.update();
            if(drawRectangleProcessorFar.satRectLeft > 0) {
                if (selection == DrawRectangleProcessorFar.Selected.RIGHT) {
                    mr.SetWristPositionUp(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -15, -15, -15, -15);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -9, 9, -9, 9);

                    mr.encoderDrive(0.35, -11,-11, -11, -11);

                    mr.encoderDrive(0.35, 6, 6, 6, 6);

                    sleep(1000);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                    double t = 30-getRuntime();
                    long sleeptime = (long) t*1000;
                    telemetry.addData("time: ", t);
                    telemetry.addData("this.time: ", getRuntime());
                    telemetry.addData("Sleeptime: ", sleeptime);
                    telemetry.update();
                    sleep(sleeptime);

                }

                if (selection == DrawRectangleProcessorFar.Selected.MIDDLE) {

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -50, -50, -50, -50);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 23, 23, 23, 23);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                    double t = 30-getRuntime();
                    long sleeptime = (long) t*1000;
                    telemetry.addData("time: ", t);
                    telemetry.addData("this.time: ", getRuntime());
                    telemetry.addData("Sleeptime: ", sleeptime);
                    telemetry.update();
                    sleep(sleeptime);

                }

                if (selection == DrawRectangleProcessorFar.Selected.LEFT) {

                    mr.encoderDrive(0.35, -3, -3, -3, -3);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 6, -6, 6, -6);

                    mr.encoderDrive(0.35, -27, -27, -27, -27);

                    mr.encoderDrive(0.35, 10, 10, 10, 10);

                    sleep(1000);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                    double t = 30-getRuntime();
                    long sleeptime = (long) t*1000;
                    telemetry.addData("time: ", t);
                    telemetry.addData("this.time: ", getRuntime());
                    telemetry.addData("Sleeptime: ", sleeptime);
                    telemetry.update();
                    sleep(sleeptime);

                }
            }

        }
        catch(Exception ex) {}

        }
    }



