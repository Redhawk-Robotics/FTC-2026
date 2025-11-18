package org.firstinspires.ftc.teamcode;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;
import org.firstinspires.ftc.robotcore.external.Telemetry;

// adb connect 192.168.43.1:5555 (Connect to the Control Hub via ADB)
// 192.168.43.1:8080/dash (Connect to FTC Dashboard)

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
        strafe = gamepad1.left_stick_x;
        rot = gamepad1.right_stick_x;

        drive.drive(forward,strafe,rot);

    }

}

