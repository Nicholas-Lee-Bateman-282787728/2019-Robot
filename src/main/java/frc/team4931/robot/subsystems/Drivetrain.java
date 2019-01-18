/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4931.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.team4931.robot.RobotMap;
import frc.team4931.robot.commands.DriveWithJoystick;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX motorFrontLeft;
  private WPI_TalonSRX motorFrontRight;
  private WPI_TalonSRX motorBackLeft;
  private WPI_TalonSRX motorBackRight;

  private MecanumDrive mecanumDrive;

  public Drivetrain() {
    motorFrontLeft = new WPI_TalonSRX(RobotMap.MOTOR_DT_FRONT_LEFT);
    motorFrontRight = new WPI_TalonSRX(RobotMap.MOTOR_DT_FRONT_RIGHT);
    motorBackLeft = new WPI_TalonSRX(RobotMap.MOTOR_DT_BACK_LEFT);
    motorBackRight = new WPI_TalonSRX(RobotMap.MOTOR_DT_BACK_RIGHT);

    mecanumDrive = new MecanumDrive(motorFrontLeft, motorFrontRight, motorBackLeft, motorBackRight);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithJoystick());
  }

  public void mecanumDrive(double ySpeed, double xSpeed, double zRotation) {
    mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
  }
}
