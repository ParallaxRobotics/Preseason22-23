package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.HardwareRobot;

@TeleOp
public class TeleOpFirstComp extends LinearOpMode {

    @Override

    public void runOpMode() throws InterruptedException {

        HardwareRobot robot = new HardwareRobot();
        ElapsedTime timer = new ElapsedTime();

        robot.init(hardwareMap);

        DriveTrain driveTrain = new DriveTrain(robot, timer);

        waitForStart();


        if (isStopRequested()) return;


        while(opModeIsActive()) {
            driveTrain.Update(gamepad1, gamepad2);

        }
    }
}
