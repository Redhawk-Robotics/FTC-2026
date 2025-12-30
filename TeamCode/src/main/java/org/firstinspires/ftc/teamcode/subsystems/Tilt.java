package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Tilt {

    private DcMotor tiltMotor;
    private final int motorTicksPerRev = 28; // Ticks per motor revolution
    private final int gearRatio = 125; // Total gear reduction (5^3)
    private final int outputRev = 12941; // PLACEHOLDER
    private final int targetPos = motorTicksPerRev * gearRatio * outputRev;

    private boolean isTilted = false;

    public void init(HardwareMap hwMap) {
        tiltMotor = hwMap.get(DcMotor.class, "TiltMotor");
        tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tiltMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tiltMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        tiltMotor.setTargetPosition(targetPos);
    }

    public void tilt(boolean tiltBind) {
        if (tiltBind && !isTilted) {
            tiltMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            isTilted = true;
        }
        if (tiltBind && isTilted) {
            tiltMotor.setPower(0.5);
            tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            isTilted = false;
        }
    }

}
