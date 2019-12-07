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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;


public class Robot extends TimedRobot {

  Joystick rightstick = new Joystick(RobotMap.JOYSTICK_DRIVE_RIGHT);
  Joystick leftstick = new Joystick(RobotMap.JOYSTICK_DRIVE_LEFT);

  AHRS ahrs;

  TankDrive tankDrive;

  Vision vision;


  double tx;
  double ty;
  double ta;


  @Override
  public void robotInit() {

    ahrs = new AHRS(SerialPort.Port.kUSB);
    ahrs.reset();
    
    tankDrive = new TankDrive();
    vision = new Vision();
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

    tankDrive.drive(rightspeed, leftspeed);

    vision.updateVisionVals(); 
  }

  @Override
  public void testPeriodic() {
  }
}
