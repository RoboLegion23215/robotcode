package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "IK 6")


public class InverseKinematicsV6 extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor leftBack;

    private DcMotor rightFront;
    private DcMotor rightBack;

    private Servo launcher;

    private DcMotor arm;

    private DcMotor hanger;

    private DcMotor intake;

    private Servo launch;

    private Servo wrister;

    private final double servoRest = 0.9;
    private final double servoLaunch = 0.5;

    private final double wristDown = 0.62;

    private final double wristDownTwo = 0.15;

    private final double wristUp = 1.0;

    private Servo leftClaw;

    private Servo rightClaw;

    private final double leftClawUp = 0.45;

    private final double leftClawDown = 0.5;

    private final double rightClawUp = 1.0;

    private final double rightClawDown = 0.7;
    double armSpeed;
    double lfSpeed;
    double rfSpeed;
    double lbSpeed;
    double rbSpeed;
    double target;

    /*public void moveDriveTrain(){

        double y = 0;
        double x = 0;
        double turn = 0;
        y = -gamepad1.left_stick_y;
        x = gamepad1.left_stick_x;

        turn = gamepad1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turn), 1);

        leftFront.setPower( (y + x + turn) / denominator);
        leftBack.setPower( (y - x + turn) / denominator);
        rightFront.setPower( (y - x - turn) / denominator);
        rightBack.setPower( (y + x - turn) / denominator);

    }*/
    public void runOpMode() {

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");
        launch = hardwareMap.get(Servo.class, "launcher");
        wrister = hardwareMap.get(Servo.class, "wrister");
        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hanger.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            lfSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
            rfSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
            lbSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;
            rbSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;

            leftFront.setPower(lfSpeed * 0.7);
            leftBack.setPower(lbSpeed * 0.7);
            rightFront.setPower(rfSpeed * 0.7);
            rightBack.setPower(rbSpeed * 0.7);

            //attachments teleop code below


            if (gamepad2.y == true) {

                launch.setPosition(servoLaunch);
                //leftFront.setPower(0.25);

            } else if (gamepad2.x == true) {

                launch.setPosition(servoRest);
                //leftFront.setPower(0.0);

            }

            if (gamepad2.dpad_down) {

                wrister.setPosition(wristDown);

            }

                if (gamepad2.dpad_up) {

                    wrister.setPosition(wristUp);

                }


                if(gamepad2.dpad_left) {

                    wrister.setPosition(wristDownTwo);

                }

                if (gamepad1.right_trigger > 0.5F) {


                    rightClaw.setPosition(rightClawDown);

                } else if (gamepad1.right_bumper) {

                    rightClaw.setPosition(rightClawUp);

                }

                if (gamepad1.left_trigger > 0.5F) {

                    leftClaw.setPosition(leftClawDown);

                } else if (gamepad1.left_bumper) {

                    leftClaw.setPosition(leftClawUp);

                }

                hanger.setPower(-gamepad2.right_stick_y * 0.6);
                arm.setPower(-gamepad2.right_stick_y * 0.6);

                hanger.setPower(-gamepad2.left_stick_y * 0.95);
                arm.setPower(-gamepad2.left_stick_y * 0.95);

            if (arm.getCurrentPosition() > 0 && hanger.getCurrentPosition() > 0
                    && arm.getCurrentPosition() < 2100 && hanger.getCurrentPosition() < 2100) {

                hanger.setPower(-gamepad2.right_stick_y * 0.6);
                arm.setPower(-gamepad2.right_stick_y * 0.6);
                wrister.setPosition(0.95);

            } else {

                hanger.setPower(-gamepad2.right_stick_y * 0.6);
                arm.setPower(-gamepad2.right_stick_y * 0.6);
                wrister.setPosition(0.95 - (arm.getCurrentPosition() / 3895.88088));

                arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                hanger.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                //0.95 - (arm.getCurrentPosition() / 3895.88088

            }

                telemetry.addData("Status", "Running");
                telemetry.addData("Arm Position:", arm.getCurrentPosition());
                telemetry.update();


            }


        }


    }

/*double y = 0;
                double x = 0;
                double turn = 0;
                y = gamepad1.left_stick_y;
                x = gamepad1.left_stick_x;

                turn = gamepad1.right_stick_x;

                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turn), 1);

                leftFront.setPower( (y + x + turn) / denominator);
                leftBack.setPower( (y - x + turn) / denominator);
                rightFront.setPower( (y - x - turn) / denominator);
                rightBack.setPower( (y + x - turn) / denominator);*/

/*if(gamepad1.left_stick_y != 0.0) {

               leftFront_motor.setPower(-gamepad1.left_stick_y);
               leftBack_motor.setPower(-gamepad1.left_stick_y);

           }

           if(gamepad1.right_stick_y != 0.0) {

               leftFront_motor.setPower(-gamepad1.right_stick_y);
               leftBack_motor.setPower(-gamepad1.right_stick_y);

           }*/

           /*vertical = -gamepad1.left_stick_y;
           horizontal = gamepad1.left_stick_x;
           pivot = gamepad1.right_stick_x;

           leftFront.setPower(pivot + (-vertical + horizontal));
           rightFront.setPower(pivot + (-vertical - horizontal));
           leftBack.setPower(pivot + (-vertical - horizontal));
           rightBack.setPower(pivot + (-vertical + horizontal));*/

/*rightFront_motor.setDirection(DcMotor.Direction.REVERSE);
           rightBack_motor.setDirection(DcMotor.Direction.REVERSE);*/

            /*lfSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x;
            rfSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x;
            lbSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x;
            rbSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x;

            leftFront.setPower(lfSpeed);
            leftBack.setPower(lbSpeed);
            rightFront.setPower(rfSpeed);
            rightBack.setPower(rbSpeed);*/

/*double vertical = 0.0;
            double horizontal = 0.0;
            double pivot = 0.0;*/

//rightBack_motor.setPower(pivot + (-vertical + horizontal));


