package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name = "OpenCV New Red", group = "Concept")
public class SimpleOpenCVNewRed extends OpMode {
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
    public void loop() {
        try {

            boolean active =true;
            while(active) {

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
                    if (selection == DrawRectangleProcessor.Selected.RIGHT) {

                    mr.encoderDrive(0.4, -3, -3, -3, -3);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(500);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -5, 5, -5, 5);

                    mr.encoderDrive(0.4, -22, -22, -22, -22);

                    mr.encoderDrive(0.4, 6, 6, 6, 6);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(300);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(300);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(0.5, 8,8,8,8);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 28, -28, 28, -28);

                    mr.SetArmPositionFive(hardwareMap);

                    mr.encoderDrive(0.4, 25,25,25,25);

                    mr.encoderDrive(0.4, -9, 9, 9, -9);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2600);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(0.5, 14, -14, -14, 14);

                    mr.encoderDrive(0.35, 10, 10, 10, 10);

                        double t = 30-getRuntime();
                        long sleeptime = (long) t*1000;
                        telemetry.addData("time: ", t);
                        telemetry.addData("this.time: ", getRuntime());
                        telemetry.addData("Sleeptime: ", sleeptime);
                        telemetry.update();
                        sleep(sleeptime);
                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -27, 39, 27, -39);
                    //forward
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -27, -27, -27, -27);
                    //turn
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 22, -22, 46, -46);

                    sleep(1000);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 1, 1, 1, 1);

                    sleep(1000);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 8, -8, -8, 8);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 14, 14, 14, 14);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(0.5, 24, -24, -24, 24);

                    mr.encoderDrive(0.5, 13, 13, 13, 13);*/

                    }

                    if (selection == DrawRectangleProcessor.Selected.MIDDLE) {

                        mr.SetArmPositionTwo(hardwareMap);

                        sleep(500);

                        mr.SetWristPositionDown(hardwareMap);

                    mr.encoderDrive(0.35, -32, -32, -32, -32);

                    mr.encoderDrive(0.35, 4, 4, 4, 4);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(500);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -29, 29, 29, -29);

                    mr.SetArmPositionFive(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 22, -22, 22, -22);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -2, 2, 2, -2);

                    mr.SetArmPosition(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 2 , 2, 2, 2);

                    sleep(1000);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(0.5, 29, -29, -29, 29);

                    mr.encoderDrive(0.35, 10, 10, 10, 10);

                        double t = 30-getRuntime();
                        long sleeptime = (long) t*1000;
                        telemetry.addData("time: ", t);
                        telemetry.addData("this.time: ", getRuntime());
                        telemetry.addData("Sleeptime: ", sleeptime);
                        telemetry.update();
                        sleep(sleeptime);

                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -20, 32, 20, -32);
                    //forward
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -27, -27, -51, -51);
                    //turn
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 22, -22, 46, -46);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -14, 14, 14, -14);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -10, -10, -10, -10);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 10, 10, 10, 10);

                    sleep(1000);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 14, -14, -14, 14);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 18, 18, 18, 18);

                    mr.SetLeftClawUp(hardwareMap);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 27, -27, -27, 27);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, 13, 13, 13);

                    sleep(1000);*/

                    }

                    if (selection == DrawRectangleProcessor.Selected.LEFT) {

                    mr.encoderDrive(0.35, -18, -18, -18, -18);

                    mr.SetArmPositionTwo(hardwareMap);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 10, -10, 10, -10);

                    mr.encoderDrive(0.35, -11, -11, -11, -11);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 7, 7, 7, 7);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(500);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 5, 5, 5, 5);

                    mr.SetArmPositionFive(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 12, -12, 12, -12);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -16, 16, 16, -16);

                    mr.SetArmPosition(hardwareMap);

                    mr.encoderDrive(0.35, 27, 27, 27, 27);

                    sleep(1500);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(0.5, 29, -29, -29, 29);

                    mr.encoderDrive(0.35, 15, 15, 15, 15);

                    double t = 30-getRuntime();
                    long sleeptime = (long) t*1000;
                    telemetry.addData("time: ", t);
                    telemetry.addData("this.time: ", getRuntime());
                    telemetry.addData("Sleeptime: ", sleeptime);
                    telemetry.update();
                    sleep(sleeptime);

                        //mr.encoderDrive(0.35, 6, 6, 6, 6);

                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -25, -25, -25, -25);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 21, -21, 45, -45);

                    sleep(1000);

                    mr.SetArmPositionTwo(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(1000);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 2, 2, 2, 2);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.SetArmPosition(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -13, 13, 13, -13);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 34, 34, 34, 34);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 30, -30, -30, 30);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, 13, 13, 13);*/
                    active = false;

                    }

                }
            }
        }
        catch(Exception ex) {}


        }

    }



