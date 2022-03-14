package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class Carusel implements Sub {

    public static double CAROUSEL_IDLE_POWER = 0;
    public static double CAROUSEL_SCORING_POWER = 0.4;
    public static double CAROUSEL_SCORING_POWER_LEFT = -0.4;

    public enum CarouselState {
        IDLE,
        SCORING_RIGHT,
        SCORING_LEFT
    }

    public DcMotor motorCarousel;

    public CarouselState carouselState;

    public Carusel(HardwareMap hardwareMap, Robot robot) {
        motorCarousel = hardwareMap.get(DcMotor.class, "carouselMotor");
        motorCarousel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        carouselState = CarouselState.IDLE;
    }

    @Override
    public void update() {
        switch (carouselState) {
            case IDLE:
                motorCarousel.setPower(CAROUSEL_IDLE_POWER);
                break;
            case SCORING_RIGHT:
                motorCarousel.setPower(CAROUSEL_SCORING_POWER);
                break;
            case SCORING_LEFT:
                motorCarousel.setPower(CAROUSEL_SCORING_POWER_LEFT);
                break;
        }
    }
}
