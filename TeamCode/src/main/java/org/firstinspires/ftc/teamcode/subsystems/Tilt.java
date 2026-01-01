package org.firstinspires.ftc.teamcode.subsystems;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Configurable
public class Tilt {

    private DcMotor tiltMotor;
    private final int motorTicksPerRev = 28; // Ticks per motor revolution
    private final int gearRatio = 125; // Total gear reduction (5^3)
    public static double outputRev = 0.2;
    private final double targetPos = motorTicksPerRev * gearRatio * outputRev;


    public void init(HardwareMap hwMap) {
        tiltMotor = hwMap.get(DcMotor.class, "TiltMotor");
        tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tiltMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tiltMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        tiltMotor.setTargetPosition((int) targetPos);
    }

    public void tilt(boolean reduceTilt, boolean increaseTilt, boolean tiltBind) {
        int startPos = 0;

        if (tiltBind) {
            tiltMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if(!tiltBind && tiltMotor.isBusy()) {
            tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        if (increaseTilt && tiltMotor.getCurrentPosition() < targetPos) {
            tiltMotor.setPower(1);
        } else {
            tiltMotor.setPower(0);
        }

        if (reduceTilt && tiltMotor.getCurrentPosition() > startPos) {
            tiltMotor.setPower(-1);
        } else {
            tiltMotor.setPower(0);
        }
    }
}

