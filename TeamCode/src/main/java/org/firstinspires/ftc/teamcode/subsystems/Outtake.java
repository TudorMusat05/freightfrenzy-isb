package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Outtake implements Sub {

    public static double CLOSED_POSITION = 0.25;
    public static double COLLECTING_POSITION = 0.9;

    public static double OUTTAKE_ON_POWER = 0.4;
    public static double OUTTAKE_IDLE_POWER = 0;
    public static double OUTTAKE_REVERSE_POWER = -0.2;
    public static double OUTTAKE_UP_POWER_MULTIPLIER = 0.5;
    public static double OUTTAKE_DOWN_POWER_MULTIPLIER = -0.3;

    public enum  ClawState {
        COLLECTING,
        CLOSED
    }

    public enum OuttakeState{
        UP,
        IDLE,
        DOWN
    }

    public ClawState clawState;
    public OuttakeState outtakeState;


    public Servo clawServo;
    public DcMotor outtakeMotor;


    public Outtake(HardwareMap hardwareMap, Robot robot){
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        clawState = ClawState.COLLECTING;
        outtakeMotor = hardwareMap.get(DcMotor.class, "outtakeMotor");
        outtakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeState = OuttakeState.IDLE;

    }

    @Override
    public void update() {
        switch (clawState) {
            case COLLECTING:
                clawServo.setPosition(COLLECTING_POSITION);
                break;
            case CLOSED:
                clawServo.setPosition(CLOSED_POSITION);
                break;
        }
//        switch (outtakeState) {
//            case UP:
//                outtakeMotor.setPower(OUTTAKE_ON_POWER);
//                break;
//            case IDLE:
//                outtakeMotor.setPower(OUTTAKE_IDLE_POWER);
//                break;
//            case DOWN:
//                outtakeMotor.setPower(OUTTAKE_REVERSE_POWER);
//                break;
//        }
    }
}
