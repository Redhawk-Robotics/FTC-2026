package org.firstinspires.ftc.teamcode.opmodes;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.robot.Robot;

@TeleOp(name = "Main Teleop", group = "Teleop")
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
        boolean resetHeading = gamepad1.a;
        robot.drive.fieldRelativeDrive(forward,strafe,rot,resetHeading);

        // Tilt
        boolean reduceTilt = gamepad2.left_bumper;
        boolean increaseTilt = gamepad2.right_bumper;
        robot.tilt.tilt(reduceTilt,increaseTilt);
        telemetry.addData("Reduce Tilt: ", reduceTilt);
        telemetry.addData("Increase Tilt: ", increaseTilt);
    }

}