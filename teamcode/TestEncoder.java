package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Test Encoder")
public class TestEncoder extends LinearOpMode {

    private DcMotor arm;

    private DcMotor hanger;

    private Servo wrister;
    int target;

    public void runOpMode() {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");
        wrister = hardwareMap.get(Servo.class, "wrister");

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hanger.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            /*wrister.setPosition(1.0);

            target = 1600;
            arm.setTargetPosition(target);
            arm.setPower(0.25);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            hanger.setTargetPosition(target);
            hanger.setPower(0.25);
            hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            sleep(5000);

            target = 0;
            arm.setTargetPosition(target);
            arm.setPower(0.25);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            hanger.setTargetPosition(target);
            hanger.setPower(0.25);
            hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            sleep(5000);*/

            wrister.setPosition(0.25);

            target = 300;
            arm.setTargetPosition(target);
            arm.setPower(0.25);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            hanger.setTargetPosition(target);
            hanger.setPower(0.25);
            hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            telemetry.addData("Status", "Running");
            telemetry.addData("Arm Position:", arm.getCurrentPosition());
            telemetry.addData("Hanger Position:", hanger.getCurrentPosition());
            telemetry.update();

        }

    }


}
