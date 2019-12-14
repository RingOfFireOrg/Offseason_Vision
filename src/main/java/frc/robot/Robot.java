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
  
  private CANSparkMax frontLeftMotor;
  private CANSparkMax frontRightMotor;
  private CANSparkMax backRightMotor;
  private CANSparkMax backLeftMotor;

  @Override
  public void robotInit() {

    ahrs = new AHRS(SerialPort.Port.kUSB);
    ahrs.reset();
    
    frontLeftMotor = new CANSparkMax(RobotMap.NEO_FRONT_LEfT, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(RobotMap.NEO_FRONT_RIGHT, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(RobotMap.NEO_BACK_RIGHT, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(RobotMap.NEO_BACK_LEFT, MotorType.kBrushless);

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
    double rightspeed = driveController.getRawAxis(5);
    double leftspeed = driveController.getRawAxis(1);
    
    neoDrive.drive(rightspeed, leftspeed, false);
  }

  @Override
  public void testPeriodic() {
  }
}
