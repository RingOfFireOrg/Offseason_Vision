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
import edu.wpi.first.wpilibj.XboxController;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {

  Joystick rightstick = new Joystick(0);
  Joystick leftstick = new Joystick(1);
  Joystick manipulatorStick = new Joystick(2);

  XboxController driveController = new XboxController(RobotMap.DRIVE_CONTROLLER);

  AHRS ahrs;

  NeoTankDrive neoDrive;
  
  public CANSparkMax frontLeftMotor;
  public CANSparkMax frontRightMotor;
  public CANSparkMax backRightMotor;
  public CANSparkMax backLeftMotor;

  @Override
  public void robotInit() {
    ahrs = new AHRS(SerialPort.Port.kUSB);
    ahrs.reset();

    neoDrive = new NeoTankDrive();
    
    frontLeftMotor = new CANSparkMax(RobotMap.NEO_FRONT_LEFT, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(RobotMap.NEO_FRONT_RIGHT, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(RobotMap.NEO_BACK_RIGHT, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(RobotMap.NEO_BACK_LEFT, MotorType.kBrushless);
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

    neoDrive.drive(rightspeed, leftspeed, true);

    // if (driveController.getYButton()){
    //   frontLeftMotor.set(0.3); 
    // } else if (driveController.getBButton()){
    //   frontRightMotor.set(0.3);
    // } else if (driveController.getAButton()){
    //   backRightMotor.set(0.3);
    // } else if (driveController.getXButton()){
    //   backLeftMotor.set(0.3);
    // } else {
    //   frontLeftMotor.set(0);
    //   frontRightMotor.set(0);
    //   backRightMotor.set(0);
    //   backLeftMotor.set(0);
    // }
  }

  @Override
  public void testPeriodic() {
  }
}
