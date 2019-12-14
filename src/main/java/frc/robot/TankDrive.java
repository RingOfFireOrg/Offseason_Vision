package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TankDrive extends DifferentialDrive {
	
	private static final int ROTATIONS_PER_INCH = 5;
	private Encoder leftEncoder = new Encoder(RobotMap.DRIVE_TRAIN_LEFT_ENCODER_A, RobotMap.DRIVE_TRAIN_LEFT_ENCODER_B, false, Encoder.EncodingType.k1X);
	private Encoder rightEncoder = new Encoder(RobotMap.DRIVE_TRAIN_RIGHT_ENCODER_A, RobotMap.DRIVE_TRAIN_RIGHT_ENCODER_B, false, Encoder.EncodingType.k1X);
	
	TankDrive() {
		super(
			new SpeedControllerGroup(
					new WPI_TalonSRX(RobotMap.MOTOR_FRONT_LEFT), 
					new WPI_VictorSPX(RobotMap.MOTOR_BACK_LEFT)),
			new SpeedControllerGroup(
					new WPI_TalonSRX(RobotMap.MOTOR_FRONT_RIGHT), 
					new WPI_VictorSPX(RobotMap.MOTOR_BACK_RIGHT))
		);

		initEncoder(leftEncoder);
		initEncoder(rightEncoder);
	}

	public void drive(double leftSpeed, double rightSpeed) {
		tankDrive(leftSpeed, rightSpeed);
	}
	
	private void initEncoder(Encoder encoder) {
		encoder.reset();
		encoder.setSamplesToAverage(ROTATIONS_PER_INCH); // noise reduction?
		encoder.setDistancePerPulse(1.0/360); // should see 1 pulse per rotation
	}
	
	public void printEncoderValue() {
		SmartDashboard.putNumber("left Encoder", leftEncoder.get());
		SmartDashboard.putNumber("left rotations", leftEncoder.getDistance());
		SmartDashboard.putNumber("right Encoder", rightEncoder.get());
		SmartDashboard.putNumber("right rotations", rightEncoder.getDistance());
	}

	public double getLeftDistance() {
		return leftEncoder.getDistance() * ROTATIONS_PER_INCH;
	}
	
	public double getRightDistance() {
		return rightEncoder.getDistance() * ROTATIONS_PER_INCH;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
}