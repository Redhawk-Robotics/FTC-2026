package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.subsystems.testMotor;

@TeleOp
public class TeleOpMain extends OpMode {

    private Robot robot;
    private testMotor tm;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        tm = new testMotor();
        tm.init(hardwareMap);
    }


    @Override
    public void loop() {

        // Drive
        double forward = gamepad1.left_stick_y;
        double strafe = -gamepad1.left_stick_x;
        double rot = -gamepad1.right_stick_x;

        robot.drive.fieldRelativeDrive(forward,strafe,rot);

        double cw = gamepad1.right_stick_y;
        double ctcw = -gamepad1.right_stick_y;
        tm.armMovement(cw,ctcw);

    }

}