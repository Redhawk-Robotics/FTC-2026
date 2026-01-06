package org.firstinspires.ftc.teamcode.subsystems;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Configurable
public class Tilt {

    private DcMotor tiltMotor;
    private static final int motorTicksPerRev = 28; // Ticks per motor revolution
    private static final int gearRatio = 125; // Total gear reduction (5^3)
    public static double outputRev = 0.3;
    private static final double targetPos = motorTicksPerRev * gearRatio * outputRev;


    public void init(HardwareMap hwMap) {
        tiltMotor = hwMap.get(DcMotor.class, "TiltMotor");
        tiltMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tiltMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tiltMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void tilt(boolean reduceTilt, boolean increaseTilt) {

        // If both are true, do nothing (or handle this case based on your logic)
        if (increaseTilt && reduceTilt) {
            tiltMotor.setPower(0);  // No movement
        } else if (increaseTilt) {
            tiltMotor.setPower(1);  // Move up
        } else if (reduceTilt) {
            tiltMotor.setPower(-1); // Move down
        } else {
            tiltMotor.setPower(0);  // Stop movement
        }
    }

}

