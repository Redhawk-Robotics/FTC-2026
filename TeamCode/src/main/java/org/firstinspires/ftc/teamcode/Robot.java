package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

// adb connect 192.168.43.1:5555 (Connect to the Control Hub via ADB)
// http://192.168.43.1:8001 FTC Panel
@Configurable
@TeleOp(name = "TeleOp")
public class Robot extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    double forward, strafe, rot;

    @Override
    public void init() {

        drive.init(hardwareMap);
    }

    @Override
    public void loop() {

        forward = gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        rot = -gamepad1.right_stick_x;

        drive.fieldRelativeDrive(forward,strafe,rot);

    }
}

// test
