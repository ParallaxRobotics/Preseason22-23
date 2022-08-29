package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opMode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name = "DriveTrain") public class DriveTrain extends LinearOpMode {
    public float x, y, z, w, pwr;
    private DcMotor BR;
    private DcMotor BL;
    private DcMotor FL;
    private DcMotor FR;
    private Servo tailServo;
    //private Servo FoundationServo;


    @Override
    public void runOpMode() throws InterruptedException {
        BR = hardwareMap.dcMotor.get("BR");
        BL = hardwareMap.dcMotor.get("BL");
        FL = hardwareMap.dcMotor.get("FL");
        FR = hardwareMap.dcMotor.get("FR");
        tailServo = hardwareMap.servo.get("tailServo");


        FR.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.REVERSE);


        FR.setPower(Range.clip(pwr - x + z, -1, 1));
        BL.setPower(Range.clip(pwr - x - z, -1, 1));
        FL.setPower(Range.clip(pwr + x - z, -1, 1));
        BR.setPower(Range.clip(pwr + x + z, -1, 1));


        waitForStart();
        while (opModeIsActive()) {

            if (gamepad1.a) {
                tailServo.setPosition(.85);
            }


            float forwardBackAxis = gamepad1.left_stick_y; //moving forward
            float leftRightAxis = -gamepad1.left_stick_x; // strafing
            float spinAxis = gamepad1.right_stick_x; // turning


            // Math tings
            float FRpower = forwardBackAxis + leftRightAxis + spinAxis;
            float FLpower = forwardBackAxis + leftRightAxis - spinAxis;
            float BRpower = forwardBackAxis - leftRightAxis + spinAxis;
            float BLpower = forwardBackAxis - leftRightAxis - spinAxis;


            FR.setPower(-FRpower);
            FL.setPower(-FLpower);
            BR.setPower(-BRpower);
            BL.setPower(-BLpower);


        }}}
