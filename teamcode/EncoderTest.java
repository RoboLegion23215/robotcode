package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Encoder Test")


public class EncoderTest extends LinearOpMode {

        private DcMotor leftFront;
        private DcMotor leftBack;

        private DcMotor rightFront;
        private DcMotor rightBack;

        private Servo launcher;

        private DcMotor arm;

        private Servo launch;

        private Servo wrister;

        private final double servoLaunch = 0.5;
        private final double servoRest = 0.0;

        private final double wristUp = 0.16;

        private final double wristDown = 0.41;

        private final double wristDownTwo = 0.8;

        private Servo claw;
        private final double clawUp = 0.075;

        private final double clawDown = 0.0;
        double armSpeed;
        double lfSpeed;
        double rfSpeed;
        double lbSpeed;
        double rbSpeed;
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
            launch = hardwareMap.get(Servo.class, "launcher");
            wrister = hardwareMap.get(Servo.class, "wrister");
            claw = hardwareMap.get(Servo.class, "claw");

            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            rightFront.setDirection(DcMotor.Direction.REVERSE);
            rightBack.setDirection(DcMotor.Direction.REVERSE);

            /*double vertical = 0.0;
            double horizontal = 0.0;
            double pivot = 0.0;*/

       /*vertical = -gamepad1.left_stick_y;
       horizontal = -gamepad1.left_stick_x;
       pivot = -gamepad1.right_stick_x;

       leftFront_motor.setPower(pivot + (-vertical + horizontal));
       rightFront_motor.setPower(pivot + (-vertical - horizontal));
       leftBack_motor.setPower(pivot + (-vertical - horizontal));
       rightBack_motor.setPower(pivot + (-vertical + horizontal));*/

            telemetry.addData("Status", "Initialized");
            telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {

           /*rightFront_motor.setDirection(DcMotor.Direction.REVERSE);
           rightBack_motor.setDirection(DcMotor.Direction.REVERSE);*/

                /*lfSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_y;
                rfSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_y;
                lbSpeed = gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_y;
                rbSpeed = gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_y;

                leftFront.setPower(lfSpeed);
                leftBack.setPower(lbSpeed);
                rightFront.setPower(rfSpeed);
                rightBack.setPower(rbSpeed);*/

                double y = 0;
                double x = 0;
                double turn = 0;
                y = -gamepad1.left_stick_y;
                x = gamepad1.left_stick_x;

                turn = gamepad1.right_stick_x;

                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turn), 1);

                leftFront.setPower( (-turn + x - y) / denominator);
                leftBack.setPower( (-turn - x - y) / denominator);
                rightFront.setPower( (turn + x - y) / denominator);
                rightBack.setPower( (turn - x - y) / denominator);

                if(gamepad1.a == true) {

                    launch.setPosition(servoLaunch);
                    //leftFront.setPower(0.25);

                }
                else if(gamepad1.b == true) {

                    launch.setPosition(servoRest);
                    //leftFront.setPower(0.0);

                }

                if(gamepad2.dpad_up) {


                    wrister.setPosition(wristUp);

                } else if(gamepad2.dpad_down) {


                    wrister.setPosition(wristDown);

                } else if(gamepad2.dpad_left) {

                    wrister.setPosition(wristDownTwo);

                }

                if(gamepad1.x) {


                    claw.setPosition(clawUp);

                } else if(gamepad1.y) {

                    claw.setPosition(clawDown);

                }

                armSpeed = -gamepad2.right_stick_y;

                arm.setPower(armSpeed);

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

                telemetry.addData("Status", "Running");
                telemetry.update();





            }


        }


    }
