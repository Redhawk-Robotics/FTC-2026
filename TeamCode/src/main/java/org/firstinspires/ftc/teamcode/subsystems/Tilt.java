package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Tilt {

    private DcMotor motor;
    final int motorTicksPerRev = 28; // Ticks per motor revolution
    final int gearRatio = 125; // Total gear reduction (5^3)
    final int outputRev = 12941; // PLACEHOLDER
    final int targetPos = motorTicksPerRev * gearRatio * outputRev;

    private boolean isTilted = false;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "TiltMotor");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setTargetPosition(targetPos);
    }

    public void tilt(boolean tiltBind) {
        if (tiltBind && !isTilted) {
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            isTilted = true;
        }
        if (tiltBind && isTilted) {
            motor.setPower(0.5);
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            isTilted = false;
        }
    }

}
