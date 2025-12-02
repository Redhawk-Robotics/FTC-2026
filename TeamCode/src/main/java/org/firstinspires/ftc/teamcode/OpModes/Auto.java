package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Mechanisms.MecanumDrive;

@Autonomous(name = "Auto", group = "Main")
public class Auto extends LinearOpMode {

    private MecanumDrive drive;

    @Override
    public void runOpMode() {

        drive = new MecanumDrive();
        drive.init(hardwareMap);

        telemetry.addLine("Auto Ready");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        // --- Autonomous sequence ---

        // Drive forward 24 inches
        driveForward(24);

        // Strafe left 18 inches
        strafeLeft(18);

        // Turn right 90 degrees
        turnRight(90);

        // Drive backward 12 inches
        driveBackward(12);

        // Strafe right 18 inches
        strafeRight(18);

        // Stop all motors
        drive.drive(0, 0, 0);

        telemetry.addLine("Auto Complete");
        telemetry.update();
    }

    // --- Movement helpers (simple approximation using time and power) ---
    private void driveForward(double inches) {
        drive.fieldRelativeDrive(0.5, 0, 0);
        sleepForInches(inches);
        drive.drive(0, 0, 0);
    }

    private void driveBackward(double inches) {
        drive.fieldRelativeDrive(-0.5, 0, 0);
        sleepForInches(inches);
        drive.drive(0, 0, 0);
    }

    private void strafeLeft(double inches) {
        drive.fieldRelativeDrive(0, -0.5, 0);
        sleepForInches(inches);
        drive.drive(0, 0, 0);
    }

    private void strafeRight(double inches) {
        drive.fieldRelativeDrive(0, 0.5, 0);
        sleepForInches(inches);
        drive.drive(0, 0, 0);
    }

    private void turnRight(double degrees) {
        drive.fieldRelativeDrive(0, 0, 0.5);
        sleepForDegrees(degrees);
        drive.drive(0, 0, 0);
    }

    private void turnLeft(double degrees) {
        drive.fieldRelativeDrive(0, 0, -0.5);
        sleepForDegrees(degrees);
        drive.drive(0, 0, 0);
    }

    // --- Sleep approximations for movement (adjust experimentally) ---
    private void sleepForInches(double inches) {
        long duration = (long)(inches * 100); // 100 ms per inch (adjust!)
        sleep(duration);
    }

    private void sleepForDegrees(double degrees) {
        long duration = (long)(degrees * 15); // 15 ms per degree (adjust!)
        sleep(duration);
    }
}


//Gets ready to drive.
//Waits for the Start button.
//Drives forward 24 inches.
//Moves left 18 inches.
//Turns right 90 degrees.
//Drives backward 12 inches.
//Moves right 18 inches.
//Stops.
//Says “Auto Complete.”