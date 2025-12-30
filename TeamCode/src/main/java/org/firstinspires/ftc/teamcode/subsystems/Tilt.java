package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Tilt {

    private DcMotor tiltMotor;
    private final int motorTicksPerRev = 28; // Ticks per motor revolution
    private final int gearRatio = 125; // Total gear reduction (5^3)
    private final double outputRev = 0.5; // PLACEHOLDER
    private final double targetPos = motorTicksPerRev * gearRatio * outputRev;
    private final int startPos = 0;


    public void init(HardwareMap hwMap) {
        tiltMotor = hwMap.get(DcMotor.class, "TiltMotor");
        tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tiltMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tiltMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        tiltMotor.setTargetPosition((int) targetPos);
    }

    public void tilt(boolean reduceTilt, boolean increaseTilt, boolean tiltBind) {

        if (tiltBind) {
            tiltMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if (increaseTilt) {
            tiltMotor.setTargetPosition((int) targetPos);
            tiltMotor.setPower(0.5);

            if (tiltMotor.getCurrentPosition() >= targetPos) {
                tiltMotor.setPower(0);
            }
        }

        if (reduceTilt) {
            tiltMotor.setTargetPosition(startPos);
            tiltMotor.setPower(0.5);

            if (tiltMotor.getCurrentPosition() <= startPos) {
                tiltMotor.setPower(0);
            }
        }
    }
}
