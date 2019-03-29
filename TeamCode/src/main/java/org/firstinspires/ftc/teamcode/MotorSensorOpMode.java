package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
// @Disabled
public class MotorSensorOpMode extends OpMode {
    private Robot robot = new Robot();

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        if (robot.getHallSensor()) {
            robot.setSpeed(0.0);
        } else {
            robot.setSpeed(0.5);
        }
        telemetry.addData("Motor Revs", robot.getRotations());
    }
}
