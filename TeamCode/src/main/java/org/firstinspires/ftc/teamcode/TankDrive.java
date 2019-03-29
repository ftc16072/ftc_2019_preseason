package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

class TankDrive {
    private DcMotor leftDriveMotor;
    private DcMotor rightDriveMotor;

    void init(HardwareMap hwMap) {
        leftDriveMotor = hwMap.get(DcMotor.class, "left_drive");
        rightDriveMotor = hwMap.get(DcMotor.class, "right_drive");
        leftDriveMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void drive(double leftSpeed, double rightSpeed) {
        leftDriveMotor.setPower(leftSpeed);
        rightDriveMotor.setPower(rightSpeed);
    }

    void stop() {
        drive(0.0, 0.0);
    }
}
