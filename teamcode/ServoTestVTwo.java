package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Test 2")


public class ServoTestVTwo extends LinearOpMode {

        private Servo leftClaw;

        private Servo rightClaw;

        private final double leftClawUp = 0.075;

        private final double leftClawDown = 0.0;

        private final double rightClawUp = 0.925;

        private final double rightClawDown = 1.0;

        public void runOpMode() {

            leftClaw = hardwareMap.get(Servo.class, "leftClaw");
            rightClaw = hardwareMap.get(Servo.class, "rightClaw");

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

                if(gamepad1.left_trigger > 0.5F) {


                    leftClaw.setPosition(leftClawDown);

                } else if(gamepad1.left_bumper) {

                    leftClaw.setPosition(leftClawUp);

                }

                if(gamepad1.right_trigger > 0.5F) {

                    rightClaw.setPosition(rightClawDown);

                } else if(gamepad1.right_bumper) {

                    rightClaw.setPosition(rightClawUp);

                }
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

           leftFront_motor.setPower(pivot + (-vertical + horizontal));
           rightFront_motor.setPower(pivot + (-vertical - horizontal));
           leftBack_motor.setPower(pivot + (-vertical - horizontal));
           rightBack_motor.setPower(pivot + (-vertical + horizontal));*/

                telemetry.addData("Status", "Running");
                telemetry.update();





            }


        }


    }
