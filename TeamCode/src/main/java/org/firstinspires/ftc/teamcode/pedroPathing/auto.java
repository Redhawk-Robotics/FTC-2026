package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.geometry.BezierLine;

@Autonomous(name = "Auto", group = "Pedro Pathing")
public class auto extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Initialize follower
        Follower follower = Constants.createFollower(hardwareMap);

        // Set starting pose (x, y, heading in radians)
        Pose startPose = new Pose(0, 0, 0);  // Starting at origin
        follower.setStartingPose(startPose);

        // Wait for the start signal
        waitForStart();
        if (isStopRequested()) return;

        // Create a simple straight-line path forward 24 inches
        Path path = new Path(new BezierLine(startPose, new Pose(24, 0, 0))); // 24 inches forward along the X-axis

        // Start following the path
        follower.followPath(path);

        // Follow the path until complete
        while (opModeIsActive() && follower.isBusy()) {
            // Continuously update follower to adjust robot's movement
            follower.update();

            // Print telemetry data to monitor robot status
            telemetry.addData("Robot X Position", follower.getPose().getX());
            telemetry.addData("Robot Y Position", follower.getPose().getY());
            telemetry.addData("Robot Heading", follower.getPose().getHeading());
            telemetry.addData("Path Progress", follower.isBusy());
            telemetry.update();
        }

        // Stop robot after path completion
        stopRobot();
    }

    // This stops the robot when it's done following the path
    private void stopRobot() {
        // Set all motors to zero power (stop the robot)
        Follower follower = Constants.createFollower(hardwareMap);
        follower.startTeleopDrive(true);
        follower.setTeleOpDrive(0, 0, 0, true);
    }
}
