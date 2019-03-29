package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    private DigitalChannel hallSensor;
    private DcMotor testMotor;
    private double ticksPerRevTestMotor;
    private Servo testServo;

    void init(HardwareMap hwMap) {
        hallSensor = hwMap.get(DigitalChannel.class, "hall_sensor");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);

        testMotor = hwMap.get(DcMotor.class, "test_motor");
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRevTestMotor = testMotor.getMotorType().getTicksPerRev();

        testServo = hwMap.get(Servo.class, "test_servo");
    }

    void setServoPosition(double position) {
        testServo.setPosition(position);
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
