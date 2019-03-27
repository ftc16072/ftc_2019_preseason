package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class Robot {
    private DigitalChannel hallSensor;
    private DcMotor testMotor;

    Robot(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        testMotor = opMode.hardwareMap.get(DcMotor.class, "test_motor");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void setSpeed(double speed) {
        testMotor.setPower(speed);
    }

    double getRotations() {
        return ((double) testMotor.getCurrentPosition()) / testMotor.getMotorType().getTicksPerRev();
    }

    boolean getHallSensor() {
        return hallSensor.getState();
    }
}
