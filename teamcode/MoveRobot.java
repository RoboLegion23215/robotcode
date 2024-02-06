package org.firstinspires.ftc.teamcode;

import  java.lang.Thread;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class MoveRobot extends Thread
{

    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;

    public MoveRobot(final HardwareMap hardwareMap) {

        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

    }

    public void TurnLeft(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(motorPower);
            rightBack.setPower(-1 * motorPower);
            leftFront.setPower(motorPower);
            rightFront.setPower(motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void TurnRight(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(-1 * motorPower);
            rightBack.setPower(motorPower);
            leftFront.setPower(-1 * motorPower);
            rightFront.setPower(-1 * motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void StrafeLeft(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(-1 * motorPower);
            rightBack.setPower(motorPower);
            leftFront.setPower(-1* motorPower);
            rightFront.setPower(motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void StrafeRight(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(motorPower);
            rightBack.setPower(-1 * motorPower);
            leftFront.setPower(-1 * motorPower);
            rightFront.setPower(-1 * motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void Foward(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(-1* motorPower);
            rightBack.setPower(-1 * motorPower);
            leftFront.setPower(-1* motorPower);
            rightFront.setPower(motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void Backward(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(motorPower);
            rightBack.setPower(motorPower);
            leftFront.setPower(motorPower);
            rightFront.setPower(-1 * motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void DiagonalUpLeft(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(-1 * motorPower);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void DiagonalUpRight(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(0.0);
            rightBack.setPower(-1 * motorPower);
            leftFront.setPower(-1 * motorPower);
            rightFront.setPower(0.0);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void DiganoalDownLeft(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(0.0);
            rightBack.setPower(motorPower);
            leftFront.setPower(motorPower);
            rightFront.setPower(0.0);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

    public void DiagonalDownRight(double motorPower, long moveSleep, long delaySleep)  {
        try {

            leftBack.setPower(motorPower);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(-1 * motorPower);

            sleep(moveSleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);

            sleep(delaySleep);

            leftBack.setPower(0.0);
            rightBack.setPower(0.0);
            leftFront.setPower(0.0);
            rightFront.setPower(0.0);
        }
        catch (Exception ex)
        {

        }
    }

}
