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


public class Robot extends TimedRobot {

  Joystick leftJoytick = new Joystick(RobotMap.JOYSTICK_DRIVE_LEFT);
  Joystick rightJoystick = new Joystick(RobotMap.JOYSTICK_DRIVE_RIGHT);

  AHRS ahrs;

  TankDrive tankDrive;


  @Override
  public void robotInit() {

    ahrs = new AHRS(SerialPort.Port.kUSB);
		ahrs.reset();
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
    double leftspeed = UtilityMath.squareWithSignReturn(leftJoystick.getY());
    double rightspeed = UtilityMath.squareWithSignReturn(rightJoystick.getY());

    tankDrive.drive(rightspeed, leftspeed);
  }

  @Override
  public void testPeriodic() {
  }
}
