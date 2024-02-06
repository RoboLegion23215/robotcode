package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Arm Test")


public class ArmTest extends LinearOpMode {

    private DcMotor arm;

    double armSpeed;

    public void runOpMode() {

        arm = hardwareMap.get(DcMotor.class, "arm");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            armSpeed = -gamepad2.left_stick_y;

            arm.setPower(-gamepad2.left_stick_y);

            telemetry.addData("Status", "Running");
            telemetry.addData("Encoder value", arm.getCurrentPosition());
            telemetry.update();





        }


    }


}
