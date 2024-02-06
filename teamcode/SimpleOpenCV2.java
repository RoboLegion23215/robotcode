package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous(name = "OpenCV Test 2", group = "Concept")
public class SimpleOpenCV2 extends OpMode {
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


                DrawRectangleProcessor.Selected selection = drawRectangleProcessor.getSelection();
                MoveRobotEncoder mr = new MoveRobotEncoder(hardwareMap);

                telemetry.addData("Identified", drawRectangleProcessor.getSelection());
                telemetry.addData("Left", drawRectangleProcessor.satRectLeft);
                telemetry.addData("Right", drawRectangleProcessor.satRectRight);
                telemetry.addData("Middle", drawRectangleProcessor.satRectMiddle);
                telemetry.update();

                sleep(1000);

                    //next

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 20, -32, -20, 32);
                    //forward
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -27, -27, -51, -51);
                    //turn
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -22, 22, -46, 46);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 10, -10, -10, 10);

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

                    sleep(2000);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -10, 10, 10, -10);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 18, 18, 18, 18);

                    mr.SetLeftClawUp(hardwareMap);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -27, 27, 27, -27);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, 13, 13, 13);

                    sleep(10000);

                telemetry.addData("Identified", drawRectangleProcessor.getSelection());
                telemetry.addData("Left", drawRectangleProcessor.satRectLeft);
                telemetry.addData("Right", drawRectangleProcessor.satRectRight);
                telemetry.addData("Middle", drawRectangleProcessor.satRectMiddle);
                telemetry.update();
            }
            catch(Exception ex) {}

         }
 }


