package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class Robot {
    private DigitalChannel hallSensor;

    void init(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        hallSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    boolean getHallSensor() {
        return hallSensor.getState();
    }
}
