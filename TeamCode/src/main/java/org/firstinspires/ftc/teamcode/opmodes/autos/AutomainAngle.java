package org.firstinspires.ftc.teamcode.opmodes.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.Robot;

@Autonomous(name = "fwd auto angle", group = "auto")
public class AutomainAngle extends LinearOpMode {
    private Robot robot;

    @Override
    public void runOpMode() {
        init_resources();
        waitForStart();

        long drive_time = 3 * 1000; // ms

        robot.drive.drive(-1, 0, 0);
        sleep(500);
        robot.drive.drive(0,0,-1);
        sleep(10);
        robot.drive.drive(0, 0, 0); // reset
    }

    public void init_resources() {
        robot = new Robot(hardwareMap);
    }
}
