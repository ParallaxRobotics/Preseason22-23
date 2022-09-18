package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.HardwareRobot;

import java.sql.Driver;

public class DriveTrain {

    HardwareRobot robot;
    public ElapsedTime timer;
    double DriveSen = 0.6;

    public  enum DriveState {
        START,
        IDLE,
        FORWARDS,
        STOP,
        BACKWARDS
    }

    public static DriveState state = DriveState.IDLE;

    public DriveTrain(HardwareRobot r, ElapsedTime timer) {
        robot = r;
        this.timer = timer;
    }


    public void Update(Gamepad gamepad1, Gamepad gamepad2) {

        double y = gamepad1.left_stick_x;
        double x = -gamepad1.left_stick_y;
        double rx = 0.7 * gamepad1.right_stick_x;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        if (denominator == 0) {
            robot.frontLeft.setPower(0);
            robot.frontRight.setPower(0);
            robot.backLeft.setPower(0);
            robot.backRight.setPower(0);
        }

        else {
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x - rx) / denominator;
            double frontRightPower = (y - x + rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            robot.frontLeft.setPower(DriveSen * frontLeftPower);
            robot.frontRight.setPower(DriveSen * frontRightPower);
            robot.backLeft.setPower(DriveSen * backLeftPower);
            robot.backRight.setPower(DriveSen * backRightPower);
        }


    }
}