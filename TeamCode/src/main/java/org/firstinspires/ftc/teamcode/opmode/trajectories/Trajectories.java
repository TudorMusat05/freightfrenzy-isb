package trajectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trajectories {
    public static final Pose2d START_POSE = new Pose2d(-12, -64, Math.toRadians(90));
    public static double MAX_VEL = 30;
    public static double MAX_ACCEL = 30;
    public static double MAX_ANG_VEL = Math.toRadians(60);
    public static double MAX_ANG_ACCEL = Math.toRadians(60);
    public static double TRACK_WIDTH = 19; // in


    public static final TrajectoryVelocityConstraint BASE_VEL_CONSTRAINT = new MinVelocityConstraint(Arrays.asList(new AngularVelocityConstraint(Math.toRadians(90)), new MecanumVelocityConstraint(MAX_VEL, TRACK_WIDTH)));
    public static final TrajectoryAccelerationConstraint BASE_ACCEL_CONSTRAINT = new ProfileAccelerationConstraint(MAX_ACCEL);

    private static Pose2d getTrajectorySequenceEndPos(List<Trajectory> trajectories) {
        if (trajectories.size() == 0) {
            return START_POSE;
        } else {
            return trajectories.get(trajectories.size() - 1).end();
        }
    }

    private static TrajectoryBuilder makeTrajectoryBuilder(List<Trajectory> trajectories, double startHeading, TrajectoryVelocityConstraint velocityConstraint, TrajectoryAccelerationConstraint accelerationConstraint) {
        return new TrajectoryBuilder(getTrajectorySequenceEndPos(trajectories), startHeading, velocityConstraint, accelerationConstraint);
    }

    private static TrajectoryBuilder makeTrajectoryBuilder(List<Trajectory> trajectories, double startHeading) {
        return new TrajectoryBuilder(getTrajectorySequenceEndPos(trajectories), startHeading, BASE_VEL_CONSTRAINT, BASE_ACCEL_CONSTRAINT);
    }

    public static List<Trajectory> getTrajectories() {
        List<Trajectory> trajectories = new ArrayList<>();

        trajectories.add(makeTrajectoryBuilder(trajectories, Math.toRadians(90))
                .lineToLinearHeading(new Pose2d(-12, -44, Math.toRadians(90)))
                .build()
        );

        trajectories.add(makeTrajectoryBuilder(trajectories, Math.toRadians(90))
                .lineToSplineHeading(new Pose2d(-60, -64, Math.toRadians(30)))
                .build()
        );

        trajectories.add(makeTrajectoryBuilder(trajectories, Math.toRadians(30))
                .lineToLinearHeading(new Pose2d(-30, -70, Math.toRadians(0)))
                .build()
        );

        trajectories.add(makeTrajectoryBuilder(trajectories, Math.toRadians(0))
                .lineToLinearHeading(new Pose2d(42, -70, Math.toRadians(0)))
                .build()
        );
        return trajectories;
    }
}
