package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
// @Disabled
public class SensorOpMode extends OpMode {
    private Robot robot;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(this);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        telemetry.addData("Sensor", robot.getHallSensor());

    }
}
