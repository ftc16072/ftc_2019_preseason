package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

class Robot {
    TankDrive drivetrain = new TankDrive();

    void init(HardwareMap hwMap) {
        drivetrain.init(hwMap);
    }

    void stop() {
        drivetrain.stop();
    }
}
