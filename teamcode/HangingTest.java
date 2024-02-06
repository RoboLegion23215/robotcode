package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Hanging Test")


public class HangingTest extends LinearOpMode {

    private DcMotor hanger;

    private DcMotor arm;

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

        hanger = hardwareMap.get(DcMotor.class, "hanger");
        arm = hardwareMap.get(DcMotor.class, "arm");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

                hanger.setPower(-gamepad2.right_stick_y);
                arm.setPower(-gamepad2.right_stick_y);

                telemetry.addData("Status", "Running");
                telemetry.addData("Hanger Position:", hanger.getCurrentPosition());
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


