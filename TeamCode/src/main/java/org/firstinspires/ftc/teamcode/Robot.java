package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class Robot {
    private DigitalChannel hallSensor;
    private DcMotor testMotor;
    private double ticksPerRevTestMotor;

    Robot(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);

        testMotor = opMode.hardwareMap.get(DcMotor.class, "test_motor");
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRevTestMotor = testMotor.getMotorType().getTicksPerRev();
    }

    void setSpeed(double speed) {
        testMotor.setPower(speed);
    }

    double getRotations() {
        return ((double) testMotor.getCurrentPosition()) / ticksPerRevTestMotor;
    }

    boolean getHallSensor() {
        return hallSensor.getState();
    }
}
