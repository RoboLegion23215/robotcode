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
@Autonomous(name = "OpenCV Test", group = "Concept")
public class SimpleOpenCV extends OpMode {
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

                if (selection == DrawRectangleProcessor.Selected.LEFT || selection == DrawRectangleProcessor.Selected.NONE) {

                    //strafe

                    mr.encoderDrive(0.5, 10, -10, -10, 10);

                    mr.encoderDrive(0.5, -21, -21, -21, -21);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -10, -10, -10, -10);

                    mr.encoderDrive(0.5, 10, 10, 10, 10);

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

                    mr.encoderDrive(0.5, -10, 10, 10, -10);

                    mr.encoderDrive(0.5, 21, 21, 21, 21);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 20, -32, -20, 32);
                    //forward
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -19, -19, -19, -19);
                    //turn
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -22, 22, -46, 46);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 22, 22, 22, 22);

                    mr.SetLeftClawUp(hardwareMap);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(0.5, -24, 24, 24, -24);

                    mr.encoderDrive(0.5, 13, 13, 13, 13);

                    sleep(10000);

                }

                    //next

                if (selection == DrawRectangleProcessor.Selected.MIDDLE) {

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
                }

                //next

                if (selection == DrawRectangleProcessor.Selected.RIGHT) {

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -25, -25, -25, -25);

                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -21, 21, -45, 45);

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

                    sleep(500);

                    mr.SetArmPosition(hardwareMap);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, -13, -13, 13);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 34, 34, 34, 34);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -30, 30, 30, -30);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, 13, 13, 13);

                    /*mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 20, -32, -20, 32);
                    //forward
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -20, -20, -44, -44);
                    //turn
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -21, 21, -45, 45);

                    mr.SetArmPosition(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 17, 17, 17, 17);

                    mr.SetLeftClawUp(hardwareMap);

                    mr.SetRightClawUp(hardwareMap);

                    sleep(1000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -4, -4, -4, -4);

                    mr.SetArmPositionDown(hardwareMap);

                    sleep(2000);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -20, 20, 20, -20);

                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 13, 13, 13, 13);*/

                    sleep(10000);

                }

                    //forward
                    //mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -2, -2, -2, -2);

                    //sleep(5000);

                    //mr.SetArmPositionTwo(hardwareMap);

                    //strafe
                    //mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -12, 24, -12, -24);
                    //slight turn
                    //mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -5, 5, -10, 10);
                    //backwards
                    //mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 21, 21, 57, 57);

                    //sleep(5000);

                    //mr.SetArmPosition(hardwareMap);
                //}

                //if (selection == DrawRectangleProcessor.Selected.RIGHT) {

                   /* mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 20, -20, -32, 32);
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -37, -37, -61, -61);
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -20, 20, -44, 44);
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -21, -21, -51, -51);
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -12, 12, 23, -24);
*/
                //}

                //if (selection == DrawRectangleProcessor.Selected.LEFT || selection == DrawRectangleProcessor.Selected.NONE) {

  /*                  mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, 20, -20, -32, 32);
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -37, -37, -61, -61);
                    mr.encoderDrive(MoveRobotEncoder.TURN_SPEED, -20, 20, -44, 44);
                    mr.encoderDrive(MoveRobotEncoder.DRIVE_SPEED, -12, 12, 23, -24);*/


                //}
                //MoveRobot mr = new MoveRobot(hardwareMap);
                //mr.TurnLeft(0.25, 1000, 250);
                //if (selection == DrawRectangleProcessor.Selected.LEFT)
                //{
                //WheelEncoderTestNew wheels = new WheelEncoderTestNew();
                // wheels.runOpMode();
                //wheels.encoderDrive(WheelEncoderTestNew.DRIVE_SPEED, -27, -27, -51, 51);
                //}
            }
            catch(Exception ex) {}

         }
 }


