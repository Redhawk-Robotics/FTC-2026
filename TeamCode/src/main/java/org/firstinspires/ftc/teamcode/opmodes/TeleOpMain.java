package org.firstinspires.ftc.teamcode.opmodes;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp
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

        // Tilt
        boolean tiltBind = gamepad1.b;
        boolean reduceTilt = gamepad1.left_bumper;
        boolean increaseTilt = gamepad1.right_bumper;
        robot.tilt.tilt(reduceTilt,increaseTilt,tiltBind);
        telemetry.addData("Reduce Tilt: ", reduceTilt);
        telemetry.addData("Increase Tilt: ", increaseTilt);
    }

}