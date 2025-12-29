package org.firstinspires.ftc.teamcode.robot;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

// adb connect 192.168.43.1:5555 (Connect to the Control Hub via ADB)
// http://192.168.43.1:8001 FTC Panel
@Configurable
@TeleOp(name = "TeleOp", group = "Robot")
public class Robot {

    public MecanumDrive drive;

    public Robot(HardwareMap hwMap) {
        drive = new MecanumDrive();
        drive.init(hwMap);
    }

}

