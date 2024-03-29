package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class Tail {

    HardwareRobot robot;

    public Tail(HardwareRobot r) {

        robot = r;
    }

    public void Update(Gamepad gamepad1, Gamepad gamepad2) {

        // A - Tail Moves
        if (gamepad1.a) {
            robot.tailServo.setPosition(0.1 );

        } else {
            robot.tailServo.setPosition(0.0);
        }
    }
}
