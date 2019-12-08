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
import edu.wpi.first.wpilibj.XboxController;


public class Robot extends TimedRobot {

  public XboxController driverGamepad = new XboxController(RobotMap.DRIVER_GAMEPAD);

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
    double rightspeed = driverGamepad.getRawAxis(5);
    double leftspeed = driverGamepad.getRawAxis(4);

    tankDrive.drive(rightspeed, leftspeed);

    vision.updateVisionVals(); 
    vision.getTargetDistance();
  }

  @Override
  public void testPeriodic() {
  }
}
