package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.geometry.BezierLine;

@Autonomous(name = "Auto")
public class auto extends LinearOpMode {

    @Override
    public void runOpMode() {

        // Initialize follower
        Follower follower = Constants.createFollower(hardwareMap);

        // Set starting pose (x, y, heading in radians)
        Pose startPose = new Pose(0, 0, 0);
        follower.setStartingPose(startPose);

        waitForStart();
        if (isStopRequested()) return;

        // Build a simple straight-line path forward 24 inches
        Path path = new Path(new BezierLine(startPose, new Pose(24, 0, 0)));
        follower.followPath(path);

        // Follow the path until complete
        while (opModeIsActive() && follower.isBusy()) {
            follower.update();
        }
    }
}
