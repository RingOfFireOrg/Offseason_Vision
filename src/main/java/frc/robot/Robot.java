/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {

  Joystick rightstick = new Joystick(0);
  Joystick leftstick = new Joystick(1);
  Joystick manipulatorStick = new Joystick(2);

  AHRS ahrs;

  NeoTankDrive neoDrive;

  private static final int frontLeftMotorID = 0;
  private static final int frontRightMotorID = 1;
  private static final int backRightMotorID = 2;
  private static final int backLeftMotorID = 3;
  
  private CANSparkMax frontLeftMotor;
  private CANSparkMax frontRightMotor;
  private CANSparkMax backRightMotor;
  private CANSparkMax backLeftMotor;

  @Override
  public void robotInit() {

    ahrs = new AHRS(SerialPort.Port.kUSB);
    ahrs.reset();
    
    frontLeftMotor = new CANSparkMax(frontLeftMotorID, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(frontRightMotorID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(backRightMotorID, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(backLeftMotorID, MotorType.kBrushless);

    //demoMotor = new Spark(2);
    frontLeftMotor.restoreFactoryDefaults();
    frontRightMotor.restoreFactoryDefaults();
    backRightMotor.restoreFactoryDefaults();
    backLeftMotor.restoreFactoryDefaults();

  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopPeriodic() {
    double rightspeed = rightstick.getY();
    double leftspeed = leftstick.getY();
    
    neoDrive.drive(rightspeed, leftspeed);
  }

  @Override
  public void testPeriodic() {
  }
}
