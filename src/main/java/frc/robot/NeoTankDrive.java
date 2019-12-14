package frc.robot;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class NeoTankDrive {
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(
        new CANSparkMax(RobotMap.MOTOR_FRONT_RIGHT, MotorType.kBrushless),
        new CANSparkMax(RobotMap.MOTOR_BACK_RIGHT, MotorType.kBrushless));
    SpeedControllerGroup leftMotors = new SpeedControllerGroup(
        new CANSparkMax(RobotMap.MOTOR_FRONT_LEFT, MotorType.kBrushless),
        new CANSparkMax(RobotMap.MOTOR_BACK_LEFT, MotorType.kBrushless));


    public void drive(double rightSpeed, double leftSpeed){
        rightMotors.set(rightSpeed);
        leftMotors.set(leftSpeed);
    }
}

