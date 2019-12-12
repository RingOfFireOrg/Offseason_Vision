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

import edu.wpi.first.wpilibj.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {

  Joystick rightstick = new Joystick(0);
  Joystick leftstick = new Joystick(1);
  Joystick manipulatorStick = new Joystick(2);

  AHRS ahrs;

  TankDrive tankDrive;

  private static final int testDeviceID = 2; 
  private CANSparkMax testMotor;
  private Spark demoMotor;

  @Override
  public void robotInit() {

    ahrs = new AHRS(SerialPort.Port.kUSB);
    ahrs.reset();
    
    testMotor = new CANSparkMax(testDeviceID, MotorType.kBrushless);
    //demoMotor = new Spark(2);
    testMotor.restoreFactoryDefaults();
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
    double testSpeed = manipulatorStick.getY();


    testMotor.set(testSpeed);
    //demoMotor.set(1.75);
    // tankDrive.drive(rightspeed, leftspeed);
  }

  @Override
  public void testPeriodic() {
  }
}
