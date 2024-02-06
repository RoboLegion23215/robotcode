package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Wheel Test")


public class WheelTest extends LinearOpMode {


    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    private DcMotor arm;

    int target;

        public void runOpMode() {

           /*leftFront = hardwareMap.get(DcMotor.class, "leftFront");
            leftBack = hardwareMap.get(DcMotor.class, "leftBack");
            rightFront = hardwareMap.get(DcMotor.class, "rightFront");
            rightBack = hardwareMap.get(DcMotor.class, "rightBack");*/
            arm = hardwareMap.get(DcMotor.class, "arm");

            /*leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            rightFront.setDirection(DcMotor.Direction.REVERSE);
            rightBack.setDirection(DcMotor.Direction.REVERSE);*/

            telemetry.addData("Status", "Initialized");
            telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {

                arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                target = 500;
                arm.setTargetPosition(target);
                arm.setPower(0.75);
                arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                //MoveRobot mr = new MoveRobot(hardwareMap);
                //mr.TurnLeft(0.25, 1000, 250);

                //WheelEncoderTestNew wheels = new WheelEncoderTestNew();
                //wheels.encoderDrive(WheelEncoderTestNew.DRIVE_SPEED, -27, -27, -51, 51);

                telemetry.addData("Status", "Running");
                telemetry.update();





            }


        }


    }
