package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Test")


public class ServoTest extends LinearOpMode {

        private Servo launch;

        private Servo wrister;

        private Servo claw;

        private Servo leftClaw;

        private Servo rightClaw;

        private final double servoLaunch = 0.5;
        private final double servoRest = 0.0;

        private final double wristUp = 0.16;

        private final double wristDown = 0.41;

        private final double wristTruss = 0.0;

        private final double leftClawUp = 0.0;

    private final double leftClawDown = 0.0;

    private final double rightClawUp = 0.0;

    private final double rightClawDown = 0.0;


    double target;

        public void runOpMode() {

            launch = hardwareMap.get(Servo.class, "launcher");
            wrister = hardwareMap.get(Servo.class, "wrister");
            leftClaw = hardwareMap.get(Servo.class, "leftClaw");
            rightClaw = hardwareMap.get(Servo.class, "rightClaw");

            telemetry.addData("Status", "Initialized");
            telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {


                if(gamepad1.a == true) {

                    launch.setPosition(servoLaunch);

                }
                else if(gamepad1.b == true) {

                    launch.setPosition(servoRest);

                }

                if(gamepad2.dpad_up) {


                    wrister.setPosition(wristUp);

                }

                if(gamepad2.dpad_down) {


                    wrister.setPosition(wristDown);

                }

                if(gamepad2.dpad_right == true) {

                    wrister.setPosition(wristTruss);

                }

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

                telemetry.addData("Status", "Running");
                telemetry.update();





            }


        }


    }
