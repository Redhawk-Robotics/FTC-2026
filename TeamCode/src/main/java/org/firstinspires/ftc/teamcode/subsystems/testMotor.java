package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class testMotor {

    private DcMotor motor;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "q");
    }

    public void armMovement(double cw, double ctcw) {
        if (cw > 0) {
            motor.setPower(cw);
        }
        if (ctcw > 0) {
            motor.setPower(ctcw);
        }
    }

}
