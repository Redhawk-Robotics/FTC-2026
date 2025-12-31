package org.firstinspires.ftc.teamcode.robot;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Tilt;

public class Robot {

    public MecanumDrive drive;
    public Tilt tilt;

    public Robot(HardwareMap hwMap) {
        drive = new MecanumDrive();
        drive.init(hwMap);
        tilt = new Tilt();
        tilt.init(hwMap);
    }

}