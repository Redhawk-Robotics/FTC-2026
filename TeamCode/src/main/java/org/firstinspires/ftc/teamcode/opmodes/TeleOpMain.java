package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.robot.Robot;

public class TeleOpMain extends OpMode {

    private Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }


    @Override
    public void loop() {

        // Drive
        double forward = gamepad1.left_stick_y;
        double strafe = -gamepad1.left_stick_x;
        double rot = -gamepad1.right_stick_x;

        robot.drive.fieldRelativeDrive(forward,strafe,rot);



    }

}
