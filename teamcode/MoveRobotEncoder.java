package org.firstinspires.ftc.teamcode;

import  java.lang.Thread;
import java.util.concurrent.ExecutionException;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MoveRobotEncoder extends Thread {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;


    private DcMotor arm;

    private DcMotor hanger;

    private Servo wrister;

    private Servo leftClaw;

    private Servo rightClaw;

    private Servo launch;
    int target;

    static final double COUNTS_PER_MOTOR_REV = 537.7;
    ;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // No External Gearing.
    static final double WHEEL_DIAMETER_INCHES = 3.77953;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.25;
    static final double TURN_SPEED = 0.25;

    public MoveRobotEncoder(final HardwareMap hardwareMap) {

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        // Initialize the drive system variables.
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // When run, this OpMode should start both motors driving forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void encoderDrive(double speed,
                             double leftFrontInches, double rightFrontInches, double leftBackInches, double rightBackInches) {
        try {
            int newLeftFrontTarget;
            int newRightFrontTarget;
            int newLeftBackTarget;
            int newRightBackTarget;

            // Ensure that the OpMode is still active
            //if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftFrontTarget = leftFront.getCurrentPosition() + (int) (leftFrontInches * COUNTS_PER_INCH);
            newRightFrontTarget = rightFront.getCurrentPosition() + (int) (rightFrontInches * COUNTS_PER_INCH);
            newLeftBackTarget = leftBack.getCurrentPosition() + (int) (leftBackInches * COUNTS_PER_INCH);
            newRightBackTarget = rightBack.getCurrentPosition() + (int) (rightBackInches * COUNTS_PER_INCH);
            leftFront.setTargetPosition(newLeftFrontTarget);
            rightFront.setTargetPosition(newRightFrontTarget);
            leftBack.setTargetPosition(newLeftBackTarget);
            rightBack.setTargetPosition(newRightBackTarget);

            // Turn On RUN_TO_POSITION
            leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            leftFront.setPower(speed);
            leftBack.setPower(speed);
            rightFront.setPower(speed);
            rightBack.setPower(speed);

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (
                    (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy())) {

                // Display it for the driver.
                //telemetry.addData("Running to",  " %7d :%7d", newLeftFrontTarget,  newRightFrontTarget, newLeftBackTarget, rightBackInches);
                //telemetry.addData("Currently at",  " at %7d :%7d",
                //       leftFront.getCurrentPosition(), rightFront.getCurrentPosition(), leftBack.getCurrentPosition(), rightBack.getCurrentPosition());
                //telemetry.update();
            }

            // Stop all motion;
            leftFront.setPower(0);
            rightFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);

            // Turn off RUN_TO_POSITION
            leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(250);   // optional pause after each move.
        } catch (Exception ex) {
        }
    }

    public void SetArmPosition(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");
        wrister = hardwareMap.get(Servo.class, "wrister");

        /*arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        hanger.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/
        //wrister.setPosition(0.95);

        target = 2000;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    public void SetArmPositionTwo(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        target = 350;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }

    public void Plane(final HardwareMap hardwareMap) {

        launch = hardwareMap.get(Servo.class, "launcher");

        launch.setPosition(1.0);

    }

    public void SetArmPositionThree(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        target = 550;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void SetArmPositionFour(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        target = 200;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void SetArmPositionFive(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        target = 700;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void SetArmPositionDown(final HardwareMap hardwareMap) {

        arm = hardwareMap.get(DcMotor.class, "arm");
        hanger = hardwareMap.get(DcMotor.class, "hanger");

        target = 0;
        arm.setTargetPosition(target);
        arm.setPower(0.25);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        hanger.setTargetPosition(target);
        hanger.setPower(0.25);
        hanger.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }
    public void SetWristPositionUp(final HardwareMap hardwareMap) {

        wrister = hardwareMap.get(Servo.class, "wrister");

        wrister.setPosition(0.95);

    }

    public void SetWristPositionDown(final HardwareMap hardwareMap) {

        wrister = hardwareMap.get(Servo.class, "wrister");

        wrister.setPosition(0.25);

    }

    public void SetLeftClawDown(final HardwareMap hardwareMap) {

        leftClaw = hardwareMap.get(Servo.class, "leftClaw");

        leftClaw.setPosition(0.19);

    }

    public void SetLeftClawUp(final HardwareMap hardwareMap) {

        leftClaw = hardwareMap.get(Servo.class, "leftClaw");

        leftClaw.setPosition(0.0);

    }

    public void SetRightClawUp(final HardwareMap hardwareMap) {

        rightClaw = hardwareMap.get(Servo.class, "rightClaw");

        rightClaw.setPosition(1.0);

    }
}