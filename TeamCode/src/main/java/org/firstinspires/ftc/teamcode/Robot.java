package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    private DigitalChannel hallSensor = null;
    private DcMotor testMotor = null;
    private Servo testServo = null;
    private double testMotorTicksPerRevolution = 0;

    void init(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        testMotor = opMode.hardwareMap.get(DcMotor.class, "test_motor");
        testServo = opMode.hardwareMap.get(Servo.class, "test_servo");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        testMotorTicksPerRevolution = testMotor.getMotorType().getTicksPerRev();
    }

    boolean sensorSeesMagnet() {
        return !hallSensor.getState();  // Active Low
    }

    void setMotorSpeed(double speed) {
        testMotor.setPower(speed);
    }

    void setServoPosition(double position) {
        testServo.setPosition(position);
    }

    void stop() {
        testMotor.setPower(0.0);
        testServo.setPosition(0.0);
    }

    double getMotorRotations() {
        return ((double) testMotor.getCurrentPosition()) / testMotorTicksPerRevolution;
    }

}
