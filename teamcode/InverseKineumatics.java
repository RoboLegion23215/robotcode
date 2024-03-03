package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Inverse Kineumatics", group = "Concept")
    public class InverseKineumatics extends LinearOpMode {

    private Servo wrister; // create servo object to control a servo
    // twelve servo objects can be created on most boards

    private DcMotor arm;

    private DcMotor hanger;

    double pos = 0;    // variable to store the servo position

    int target;

    double degree = 0.00555556;

    public void runOpMode() {

        wrister = hardwareMap.get(Servo.class, "wrister");
        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hanger.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            hanger.setPower(-gamepad2.right_stick_y * 0.6);
            arm.setPower(-gamepad2.right_stick_y * 0.6);

            /*if (arm.getCurrentPosition() < 2100 && hanger.getCurrentPosition() < 2100) {

                wrister.setPosition(0.95);

            }

            if (arm.getCurrentPosition() > 2100 && hanger.getCurrentPosition() > 2100) {

                wrister.setPosition(0.95 - (arm.getCurrentPosition() / 3895.88088));

                //0.95 - (arm.getCurrentPosition() / 3895.88088

            }*/

        }

                /*if(gamepad1.a) {

                    wrister.setPosition(Range.clip(wrister.getPosition(), 1, 0 + 0.01));

                } else if(gamepad1.b) {

                    wrister.setPosition(Range.clip(1, 0, wrister.getPosition() - 0.01));

                }*/


        //MoveRobotEncoder mr = new MoveRobotEncoder(hardwareMap);

        //mr.SetArmPosition(hardwareMap);

                    /*for (pos = 0.65; pos <= 0.9; pos += degree) { // goes from 0 degrees to 180 degrees
                        // in steps of 1 degree
                        wrister.setPosition(pos); // tell servo to go to position in variable 'pos'
                        sleep(15);
                        if(pos == 0.9) break;
                    }*/
        //sleep(15);
                     /*for (pos = 0.9; pos >= 0.65; pos -= degree) { // goes from 0 degrees to 180 degrees
                         // in steps of 1 degree
                         wrister.setPosition(pos); // tell servo to go to position in variable 'pos'
                         sleep(15);
                         if(pos == 0.65) break;
                    }*/
                /*for (pos = 0.95; pos >= 0.0; pos -= 0.00555556) { // goes from 180 degrees to 0 degrees
                    wrister.setPosition(pos); // tell servo to go to position in variable 'pos'
                    sleep(15);
                }*/

        telemetry.addData("Status", "Running");
        telemetry.addData("Arm Position:", arm.getCurrentPosition());
        telemetry.addData("Hanger Position:", hanger.getCurrentPosition());
        telemetry.addData("Wrist Position", wrister.getPosition());
        telemetry.update();
    }
}
