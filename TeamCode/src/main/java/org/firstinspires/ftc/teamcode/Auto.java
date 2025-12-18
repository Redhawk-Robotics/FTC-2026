package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto Selection", group="Linear Opmode")
public class Auto extends LinearOpMode {

    private String selectedMode = "None";  // Default value for no selection
    private int modeIndex = 0;  // Index to track the current selected mode
    private String[] modes = {"AutoBlue1", "AutoBlue2", "AutoRed1", "AutoRed2"};  // All modes available

    @Override
    public void runOpMode() {
        waitForStart();  // Wait for the start of the match

        // Main loop to handle the selection
        while (opModeIsActive()) {

            // D-pad Up: Move to the next mode (down the list)
            if (gamepad1.dpad_up) {
                modeIndex = (modeIndex + 1) % modes.length;  // Loop forward through the modes
            }

            // D-pad Down: Move to the previous mode (up the list)
            if (gamepad1.dpad_down) {
                modeIndex = (modeIndex - 1 + modes.length) % modes.length;  // Loop backward through the modes
            }

            // Left Bumper: Move backward through the mode list
            if (gamepad1.left_bumper) {
                modeIndex = (modeIndex - 1 + modes.length) % modes.length;  // Go back one mode
            }

            // Right Bumper: Move forward through the mode list and select the mode
            if (gamepad1.right_bumper) {
                modeIndex = (modeIndex + 1) % modes.length;  // Go forward one mode
                selectedMode = modes[modeIndex];  // Select the mode
            }

            // Telemetry for feedback on the selected mode
            telemetry.addData("Selected Mode", selectedMode);
            telemetry.addData("Current Index", modeIndex);
            telemetry.update();

            // Small delay to prevent rapid cycling of modes
            sleep(100);
        }

        // Once the match starts, run the selected autonomous mode
        if (selectedMode.equals("AutoBlue1")) {
            new AutoBlue1().runOpMode();  // Run AutoBlue1
        } else if (selectedMode.equals("AutoBlue2")) {
            new AutoBlue2().runOpMode();  // Run AutoBlue2
        } else if (selectedMode.equals("AutoRed1")) {
            new AutoRed1().runOpMode();   // Run AutoRed1
        } else if (selectedMode.equals("AutoRed2")) {
            new AutoRed2().runOpMode();   // Run AutoRed2
        }
    }
}
