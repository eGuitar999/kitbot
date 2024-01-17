// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  private final WPI_TalonSRX frontRight = new WPI_TalonSRX(4);
  private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(2);
  private final WPI_TalonSRX backRight = new WPI_TalonSRX(5);
  private final WPI_VictorSPX backLeft = new WPI_VictorSPX(3);

  private final MotorControllerGroup right = new MotorControllerGroup(frontRight, backRight);
  private final MotorControllerGroup left = new MotorControllerGroup(frontLeft, backLeft);

  private final DifferentialDrive drive = new DifferentialDrive(left, right);

  private final XboxController controller = new XboxController(0);

  @Override
  public void robotInit() {
    right.setInverted(true);
    drive.setMaxOutput(0.2);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(-controller.getLeftY(), -controller.getRightX());

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
