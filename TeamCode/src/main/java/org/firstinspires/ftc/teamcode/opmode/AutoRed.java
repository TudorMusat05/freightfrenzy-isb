package org.firstinspires.ftc.teamcode.opmode;

import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.opmode.trajectories.Trajectories;
import org.firstinspires.ftc.teamcode.opmode.trajectories.TrajectoriesRed;
import org.firstinspires.ftc.teamcode.subsystems.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Robot;

import java.util.List;

@Autonomous
public class AutoRed extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(this, true);
        robot.drive.setPoseEstimate(Trajectories.START_POSE_BLUE);/////////////////////////////////////////////////////////

        List<Trajectory> trajectories = TrajectoriesRed.getTrajectories();

        while (!opModeIsActive() && !isStopRequested()) {
            // mare smecherie
        }

        robot.start();

        robot.drive.followTrajectory(trajectories.get(0)); // cica sa mearga in fata

        /*robot.outtake.clawState = Outtake.ClawState.SCORING;

        robot.glider2.sliderState = glider.SliderState.EXTEND;
        robot.sleep(0.8);

        robot.outtake.armState = Outtake.ArmState.FINAL;
        robot.sleep(0.2);
        robot.outtake.clawState = Outtake.ClawState.CLOSED;
        robot.sleep(0.2);

        robot.glider2.sliderState = glider.SliderState.RETRACT;
        robot.drive.followTrajectory(trajectories.get(1));

        robot.glider2.sliderState = glider.SliderState.IDLE;

        robot.intake.intakeState = Intake.IntakeState.COLLECT;

        robot.drive.followTrajectory(trajectories.get(2));

        robot.sleep(0.5);
        robot.outtake.clawState = Outtake.ClawState.SCORING;
        robot.sleep(0.1);
        robot.intake.intakeState = Intake.IntakeState.REVERSE;
        robot.sleep(0.2);
        robot.intake.intakeState = Intake.IntakeState.IDLE;

        robot.drive.followTrajectory(trajectories.get(3));

        robot.drive.followTrajectory(trajectories.get(4));

        robot.outtake.clawState = Outtake.ClawState.SCORING;

        robot.glider2.sliderState = glider.SliderState.EXTEND;
        robot.sleep(0.8);

        robot.outtake.armState = Outtake.ArmState.FINAL;
        robot.sleep(0.2);
        robot.outtake.clawState = Outtake.ClawState.CLOSED;
        robot.sleep(0.2);

        robot.glider2.sliderState = glider.SliderState.RETRACT;

        robot.drive.followTrajectory(trajectories.get(5));

        robot.glider2.sliderState = glider.SliderState.IDLE;

        robot.drive.followTrajectory(trajectories.get(6));
*/
        robot.stop();
    }
}