package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    private DigitalChannel hallSensor = null;
    private DcMotor testMotor = null;
    private Servo testServo = null;

    void init(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        testMotor = opMode.hardwareMap.get(DcMotor.class, "test_motor");
        testServo = opMode.hardwareMap.get(Servo.class, "test_servo");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    boolean sensorSeesMagnet() {
        if (hallSensor.getState() == false) {
            return true;   // sensor is LOW when it sees magnet
        }
        return false;
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

}
