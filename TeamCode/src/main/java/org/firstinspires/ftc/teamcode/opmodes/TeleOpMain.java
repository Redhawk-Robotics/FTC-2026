package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Tilt;


@TeleOp
public class TeleOpMain extends OpMode {

    private Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        telemetry.addData("Lever is tilted:", robot.tilt.isTilted);
    }


    @Override
    public void loop() {

        // Drive
        double forward = gamepad1.left_stick_y;
        double strafe = -gamepad1.left_stick_x;
        double rot = -gamepad1.right_stick_x;

        robot.drive.fieldRelativeDrive(forward,strafe,rot);

        // Tilt
        boolean tiltBind = gamepad1.b;
        robot.tilt.tilt(tiltBind);

    }

}