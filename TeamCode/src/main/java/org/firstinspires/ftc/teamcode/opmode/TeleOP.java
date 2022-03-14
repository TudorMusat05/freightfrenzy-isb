package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Carusel;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.StickyGamepad;

@Config
@TeleOp
public class TeleOP extends OpMode {
    Robot robot;

    enum DriveMode {
        FAST,
        SLOW
    }

    StickyGamepad stickyGamepad1;
    StickyGamepad stickyGamepad2;

    MultipleTelemetry telemetry;

    DriveMode driveMode;

    @Override
    public void init() {
        telemetry = new MultipleTelemetry(super.telemetry, FtcDashboard.getInstance().getTelemetry());

        robot = new Robot(this, false);

        stickyGamepad1 = new StickyGamepad(gamepad1);
        stickyGamepad2 = new StickyGamepad(gamepad2);

        driveMode = DriveMode.FAST;

        telemetry.log().add("Ready!");
    }

    @Override
    public void start() {
        robot.start();
    }

    @Override
    public void stop() {
        robot.stop();
    }

    @Override
    public void loop() {
        stickyGamepad1.update();
        stickyGamepad2.update();

        // Driver 1 controls -----------------------------------------------------------------------
        if (!robot.drive.isBusy()) {
            switch (driveMode) {
                // TODO: tune this to liking
                case FAST:
                    robot.drive.setMotorPowersFromGamepad(gamepad1, 0.6);
                    break;
                case SLOW:
                    robot.drive.setMotorPowersFromGamepad(gamepad1, 0.55);
                    break;
            }
        }

        /*if (stickyGamepad1.right_bumper) {
            driveMode = DriveMode.FAST;
        }
        if (stickyGamepad1.left_bumper) {
            driveMode = DriveMode.SLOW;
        }*/


        // -----------------------------------------------------------------------------------------

        // Driver 2 controls -----------------------------------------------------------------------
        if (gamepad1.right_trigger>0.1){
            robot.outtake.outtakeMotor.setPower(gamepad1.right_trigger * Outtake.OUTTAKE_UP_POWER_MULTIPLIER);
//            robot.outtake.outtakeState = Outtake.OuttakeState.UP;
        }
        else if (gamepad1.left_trigger > 0.1){
//            robot.outtake.outtakeState = Outtake.OuttakeState.DOWN;
            robot.outtake.outtakeMotor.setPower(gamepad1.left_trigger * Outtake.OUTTAKE_DOWN_POWER_MULTIPLIER);
        }
        else{
            robot.outtake.outtakeMotor.setPower(0);
        }

        if (gamepad1.a) {
            robot.outtake.clawState = Outtake.ClawState.CLOSED;
        }
        if (gamepad1.b){
            robot.outtake.clawState = Outtake.ClawState.COLLECTING;
        }

        if (gamepad1.left_bumper) {
            robot.carusel.carouselState = Carusel.CarouselState.SCORING_RIGHT;
        } else if (gamepad1.right_bumper ) {
            robot.carusel.carouselState = Carusel.CarouselState.SCORING_LEFT;
        } else {
            robot.carusel.carouselState = Carusel.CarouselState.IDLE;
        }
    }
}
