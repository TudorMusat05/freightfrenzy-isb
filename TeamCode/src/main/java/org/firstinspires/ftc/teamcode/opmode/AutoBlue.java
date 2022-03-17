package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.opmode.trajectories.Trajectories;
import org.firstinspires.ftc.teamcode.opmode.trajectories.TrajectoriesRed;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

import java.util.List;

import trajectories.Trajectories;

@Autonomous
public class AutoBlue extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(this, true);
        robot.drive.setPoseEstimate(Trajectories.START_POSE);

        List<Trajectory> trajectories = Trajectories.getTrajectories();

        while (!opModeIsActive() && !isStopRequested()) {
            // mare smecherie
        }
        robot.drive.followTrajectory(trajectories.get(0));
        robot.outtake.outtakeState = Outtake.OuttakeState.UP;
        robot.sleep(2);


    }
}