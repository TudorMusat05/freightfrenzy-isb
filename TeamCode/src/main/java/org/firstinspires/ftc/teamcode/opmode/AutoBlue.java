package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.opmode.trajectories.Trajectories;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

import java.util.List;

@Autonomous
public class AutoBlue extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(this, true);
        robot.drive.setPoseEstimate(Trajectories.START_POSE_BLUE);

        List<Trajectory> trajectories = Trajectories.getTrajectories();

        while (!opModeIsActive() && !isStopRequested()) {
            // mare smecherie
        }

        robot.start();

        /*robot.drive.followTrajectory(trajectories.get(0)); // cica sa mearga in fata

        robot.drive.followTrajectory(trajectories.get(1));

        robot.drive.followTrajectory(trajectories.get(2));
        robot.drive.setMotorPowers(-0.1,-0.1, -0.1, -0.1);
        robot.carusel.wheelState = Carusel.WheelState.LEFT;
        robot.sleep(2.5);
        robot.carusel.wheelState = Carusel.WheelState.STOPPED;
        robot.drive.setMotorPowers(0, 0, 0, 0);

        robot.drive.followTrajectory(trajectories.get(3));

        robot.drive.followTrajectory(trajectories.get(4));

        robot.drive.followTrajectory(trajectories.get(5));

        robot.glider2.sliderState = glider.SliderState.EXTEND;
        robot.sleep(0.6);
        robot.glider2.sliderState = glider.SliderState.IDLE;
        robot.outtake.dropperState = Outtake.DroperState.SCORING;
        robot.sleep(2);
        robot.outtake.dropperState = Outtake.DroperState.COLLECTING;
        robot.sleep(1.5);
        robot.glider2.sliderState = glider.SliderState.RETRACT;
        robot.sleep(1);
        robot.glider2.sliderState = glider.SliderState.IDLE;

        robot.drive.followTrajectory(trajectories.get(6));

        robot.drive.followTrajectory(trajectories.get(7));

        robot.drive.followTrajectory(trajectories.get(8));

        robot.stop();*/
    }
}