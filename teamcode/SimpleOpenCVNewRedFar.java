package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name = "OpenCV New Red Far", group = "Concept")
public class SimpleOpenCVNewRedFar extends OpMode {
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

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 8, -8, -8, 8);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 31, -31, 31, -31);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -32, 32, 32, -32);

                    mr.encoderDrive(0.4, 100, 100, 100, 100);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);

                    double t = 30-getRuntime();
                    long sleeptime = (long) t*1000;
                    telemetry.addData("time: ", t);
                    telemetry.addData("this.time: ", getRuntime());
                    telemetry.addData("Sleeptime: ", sleeptime);
                    telemetry.update();
                    sleep(sleeptime);

                    //middle start
                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -50, -50, -50, -50);

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

                    mr.SetArmPositionFour(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(0.5, -23, -23, -23, -23);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 23, -23, 23, -23);

                    mr.SetArmPosition(hardwareMap);

                    mr.encoderDrive(0.5, 93, 93, 93, 93);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 2, -2, -2, 2);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(500);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);*/
                    //middle end
                    //right start
                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -15, -15, -15, -15);

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

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 8, -8, -8, 8);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 31, -31, 31, -31);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -32, 32, 32, -32);

                    mr.encoderDrive(0.4, 100, 100, 100, 100);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);*/

                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 35, -35, -35, 35);

                    mr.SetArmPosition(hardwareMap);

                    sleep(3000);

                    mr.encoderDrive(0.25, 5, 5, 5, 5);

                    mr.SetLeftClawUp(hardwareMap);
                    //right end

                    //left start
                    /*mr.encoderDrive(0.35, -3, -3, -3, -3);

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

                    mr.SetArmPositionFour(hardwareMap);

                    mr.encoderDrive(0.35, -9, -9, -9, -9);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 16, -16, 16, -16);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -30, 30, 30, -30);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(0.4, 108, 108, 108, 108);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);*/

                    //park far
                    /*mr.encoderDrive(0.35, 52, -52, -52, 52);

                    mr.encoderDrive(0.35, 10, 10, 10, 10);*/

                    //left blue start
                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -15, -15, -15, -15);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 9, -9, 9, -9);

                    mr.encoderDrive(0.35, -11,-11, -11, -11);

                    mr.encoderDrive(0.35, 4, 4, 4, 4);

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

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -8, 8, 8, -8);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -31, 31, -31, 31);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 32, -32, -32, 32);

                    mr.encoderDrive(0.4, 100, 100, 100, 100);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);*/
                    //left blue end

                    /*mr.encoderDrive(0.4, 81, 81, 81, 81);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -7, 7, 7, -7);

                    mr.SetArmPositionFive(hardwareMap);

                    sleep(3000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 6, 6, 6, 6);

                    mr.SetLeftClawUp(hardwareMap);*/

                    /*mr.encoderDrive(0.35, 14, 14, 14, 14);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -5, 5, -5, 5);

                    mr.encoderDrive(0.35, 2, 2, 2, 2);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -54, 54, 54, -54);

                    mr.encoderDrive(0.5, -27, 27, 27, -27);

                    mr.encoderDrive(0.5, -27, -27, -27, -27);

                    mr. encoderDrive(MoveRobotEncoder.TURN_SPEED, 23, -23, 23, -23);*/

                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 3, 3, 3, 3);,

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -6, 6, -6, 6);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 24, -24, -24, 24);*/

                    /*mr.encoderDrive(0.5, -32, -32, -32, -32);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 23, -23, 47, -47);

                    mr.encoderDrive(0.5, 68, 68, 68, 68);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 21, -21, -21, 21);

                    mr.SetArmPosition(hardwareMap);

                    sleep(3000);

                    mr.encoderDrive(0.25, 5, 5, 5, 5);

                    mr.SetLeftClawUp(hardwareMap);*/

                    //left end

                    sleep(1000);

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

                    mr.SetArmPositionFour(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(0.5, -23, -23, -23, -23);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 23, -23, 23, -23);

                    mr.SetArmPosition(hardwareMap);

                    mr.encoderDrive(0.5, 93, 93, 93, 93);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 2, -2, -2, 2);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    sleep(500);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(1000);

                    mr.SetArmPositionDown(hardwareMap);

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

                    mr.SetArmPositionFour(hardwareMap);

                    mr.encoderDrive(0.35, -9, -9, -9, -9);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, 16, -16, 16, -16);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -30, 30, 30, -30);

                    mr.SetArmPositionDown(hardwareMap);

                    mr.encoderDrive(0.4, 108, 108, 108, 108);

                    mr.SetArmPositionThree(hardwareMap);

                    sleep(1000);

                    mr.SetWristPositionDown(hardwareMap);

                    mr.SetLeftClawUp(hardwareMap);

                    sleep(2000);

                    mr.SetWristPositionUp(hardwareMap);

                    sleep(500);

                    mr.SetArmPositionDown(hardwareMap);

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



