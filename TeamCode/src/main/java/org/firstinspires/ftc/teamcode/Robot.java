package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Robot {
    private DigitalChannel hallSensor = null;
    private DcMotor testMotor = null;
    private Servo testServo = null;
    private Rev2mDistanceSensor distanceSensor = null;
    private ColorSensor colorSensor = null;
    private BNO055IMU imu = null;
    private double testMotorTicksPerRevolution = 0;

    void init(OpMode opMode) {
        hallSensor = opMode.hardwareMap.get(DigitalChannel.class, "hall_sensor");
        testMotor = opMode.hardwareMap.get(DcMotor.class, "test_motor");
        testServo = opMode.hardwareMap.get(Servo.class, "test_servo");
        distanceSensor = opMode.hardwareMap.get(Rev2mDistanceSensor.class, "sensor_range");
        colorSensor = opMode.hardwareMap.get(ColorSensor.class, "color_sensor");
        initIMU(opMode);

        hallSensor.setMode(DigitalChannel.Mode.INPUT);
        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        testMotorTicksPerRevolution = testMotor.getMotorType().getTicksPerRev();
    }

    void initIMU(OpMode opMode) {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    double getHeading() {
        Orientation angles;

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        return angles.firstAngle;
    }

    double getDistance(DistanceUnit units) {
        return distanceSensor.getDistance(units);
    }

    NormalizedRGBA getColor() {
        NormalizedRGBA rgba = new NormalizedRGBA();
        rgba.red = colorSensor.red();
        rgba.green = colorSensor.green();
        rgba.blue = colorSensor.blue();

        return rgba;
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
