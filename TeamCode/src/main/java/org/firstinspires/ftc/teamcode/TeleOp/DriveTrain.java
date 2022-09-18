package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class DriveTrain extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        // Declare our motors
        DcMotor FL = hardwareMap.dcMotor.get("FL");   // Port:
        DcMotor BL = hardwareMap.dcMotor.get("BL");   // Port:
        DcMotor FR = hardwareMap.dcMotor.get("FR");   // Port:
        DcMotor BR = hardwareMap.dcMotor.get("BR");   // Port:
        Servo tailServo = hardwareMap.servo.get("tailServo");   // Port:

        // Reverse the right side motors
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            double rx = -0.9 * gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

            double frontLeftPower = 0;
            double backLeftPower = 0;
            double frontRightPower = 0;
            double backRightPower = 0;
            double DriveSen = 1.0;

            if (denominator == 0) {
                FL.setPower(0);
                FR.setPower(0);
                BL.setPower(0);
                BR.setPower(0);

            } else {

                frontLeftPower = (y + x + rx) / denominator;
                backLeftPower = (y - x + rx) / denominator;
                frontRightPower = (y - x - rx) / denominator;
                backRightPower = -(y + x - rx) / denominator;

                FL.setPower(DriveSen * frontLeftPower);
                FR.setPower(DriveSen * frontRightPower);
                BL.setPower(DriveSen * backLeftPower);
                BR.setPower(DriveSen * backRightPower);
            }

            if (gamepad1.a) {
                tailServo.setPosition(0.5);

            } else {
                tailServo.setPosition(0.2);
            }
        }
    }
}
