package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

import org.firstinspires.ftc.teamcode.WheelEncoderTestNew;
@Autonomous(name = "OpenCV New", group = "Concept")
public class SimpleOpenCVNew extends OpMode {
    private DrawRectangleProcessor drawRectangleProcessor;
    private VisionPortal visionPortal;


    @Override
    public void init() {
        drawRectangleProcessor = new DrawRectangleProcessor();
        visionPortal = VisionPortal.easyCreateWithDefaults(
                hardwareMap.get(WebcamName.class, "Webcam 1"), drawRectangleProcessor);
        DrawRectangleProcessor.Selected s = drawRectangleProcessor.getSelection();

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
    public void stop() {
        //visionPortal.stopStreaming();
        //visionPortal.stopStreaming();
        //requestOpModeStop();
        //terminateOpModeNow();
        return;
    }

    @Override
    public void loop() {
        try {

                DrawRectangleProcessor.Selected selection = drawRectangleProcessor.getSelection();
                MoveRobotEncoder mr = new MoveRobotEncoder(hardwareMap);

                telemetry.addData("Identified", drawRectangleProcessor.getSelection());
                telemetry.addData("Left", drawRectangleProcessor.satRectLeft);
                telemetry.addData("Right", drawRectangleProcessor.satRectRight);
                telemetry.addData("Middle", drawRectangleProcessor.satRectMiddle);

                telemetry.update();

                sleep(1000);
                selection = drawRectangleProcessor.getSelection();
                telemetry.addData("Identified", drawRectangleProcessor.getSelection());
                telemetry.addData("Left", drawRectangleProcessor.satRectLeft);
                telemetry.addData("Right", drawRectangleProcessor.satRectRight);
                telemetry.addData("Middle", drawRectangleProcessor.satRectMiddle);

                telemetry.update();
                if (drawRectangleProcessor.satRectLeft > 0) {
                    if (selection == DrawRectangleProcessor.Selected.LEFT) {

                        mr.encoderDrive(0.4, -3, -3, -3, -3);

                        mr.SetArmPositionTwo(hardwareMap);

                        mr.SetWristPositionDown(hardwareMap);

                        mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 4, -4, 4, -4);

                        mr.encoderDrive(0.4, -22, -22, -22, -22);

                        mr.encoderDrive(0.4, 8, 8, 8, 8);

                        mr.SetLeftClawUp(hardwareMap);

                        sleep(1000);

                        mr.SetArmPositionThree(hardwareMap);

                        sleep(500);

                        mr.SetWristPositionUp(hardwareMap);

                        sleep(500);

                        mr.SetArmPositionDown(hardwareMap);

                        mr.encoderDrive(0.4, 8, 8, 8, 8);

                        mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -25, 25, -25, 25);

                        mr.SetArmPositionFive(hardwareMap);

                        mr.encoderDrive(0.4, 27, 27, 27, 27);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 14, -14, -14, 14);

                        mr.SetArmPosition(hardwareMap);

                        sleep(2000);

                        mr.SetRightClawUp(hardwareMap);

                        sleep(1000);

                        mr.SetArmPositionDown(hardwareMap);

                        sleep(1000);

                        mr.encoderDrive(0.6, -15, 15, 15, -15);

                        mr.encoderDrive(0.35, 13, 13, 13, 13);

                        double t = 30-getRuntime();
                        long sleeptime = (long) t*1000;
                        telemetry.addData("time: ", t);
                        telemetry.addData("this.time: ", getRuntime());
                        telemetry.addData("Sleeptime: ", sleeptime);
                        telemetry.update();
                        sleep(sleeptime);


                    }

                    if (selection == DrawRectangleProcessor.Selected.MIDDLE) {

                        mr.encoderDrive(0.6, -30, -30, -30, -30);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                        mr.SetArmPositionTwo(hardwareMap);

                        sleep(1000);

                        mr.SetWristPositionDown(hardwareMap);

                        sleep(1000);

                        mr.SetLeftClawUp(hardwareMap);

                        sleep(1000);

                        mr.SetArmPositionThree(hardwareMap);

                        sleep(1000);

                        mr.SetWristPositionUp(hardwareMap);

                        sleep(500);

                        mr.SetArmPositionDown(hardwareMap);

                        sleep(250);

                        mr.encoderDrive(0.6, 5, 5, 5, 5);

                        mr.encoderDrive(0.35, 29, -29, -29, 29);

                        mr.encoderDrive(0.35, -22, 22, -22, 22);

                        mr.encoderDrive(0.35, 3, -3, -3, 3);

                        mr.SetArmPosition(hardwareMap);

                        sleep(3000);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                        sleep(500);

                        mr.SetRightClawUp(hardwareMap);

                        sleep(1000);

                        mr.SetArmPositionDown(hardwareMap);

                        sleep(1000);

                        mr.encoderDrive(0.6, -29, 29, 29, -29);

                        mr.encoderDrive(0.35, 10, 10, 10, 10);

                        double t = 30-getRuntime();
                        long sleeptime = (long) t*1000;
                        telemetry.addData("time: ", t);
                        telemetry.addData("this.time: ", getRuntime());
                        telemetry.addData("Sleeptime: ", sleeptime);
                        telemetry.update();
                        sleep(sleeptime);

                    }

                    if (selection == DrawRectangleProcessor.Selected.RIGHT) {

                        mr.encoderDrive(0.35, -18, -18, -18, -18);

                        mr.SetArmPositionTwo(hardwareMap);

                        mr.SetWristPositionDown(hardwareMap);

                        mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -10, 10, -10, 10);

                        mr.encoderDrive(0.35, -11, -11, -11, -11);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 6, 6, 6, 6);

                        mr.SetLeftClawUp(hardwareMap);

                        sleep(500);

                        mr.SetArmPositionThree(hardwareMap);

                        sleep(500);

                        mr.SetWristPositionUp(hardwareMap);

                        sleep(500);

                        mr.SetArmPositionDown(hardwareMap);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                        mr.SetArmPositionFive(hardwareMap);

                        mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -12, 12, -12, 12);

                        mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 15, -15, -15, 15);

                        mr.SetArmPosition(hardwareMap);

                        mr.encoderDrive(0.35, 28, 28, 28, 28);

                        sleep(1500);

                        mr.SetRightClawUp(hardwareMap);

                        sleep(1000);

                        mr.SetArmPositionDown(hardwareMap);

                        sleep(2000);

                        mr.encoderDrive(0.5, -29, 29, 29, -29);

                        mr.encoderDrive(0.35, 10, 10, 10, 10);

                        double t = 30-getRuntime();
                        long sleeptime = (long) t*1000;
                        telemetry.addData("time: ", t);
                        telemetry.addData("this.time: ", getRuntime());
                        telemetry.addData("Sleeptime: ", sleeptime);
                        telemetry.update();
                        sleep(sleeptime);
                        //visionPortal.stopStreaming();

                    }
                }


            }
        catch(Exception ex) {}

        }
    }



