/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4931.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.team4931.robot.commands.ShootHatch;
import frc.team4931.robot.commands.ArmStop;
import frc.team4931.robot.commands.ChangeVelcroState;
import frc.team4931.robot.commands.ExtendClimberArm;
import frc.team4931.robot.commands.ExtendHatchGrabber;
import frc.team4931.robot.commands.RetractClimberArm;
import frc.team4931.robot.commands.Latch;
import frc.team4931.robot.commands.Release;
import frc.team4931.robot.commands.ResetHatchGrabber;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OperatorInput {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  private Joystick joystick;

  public OperatorInput() {
    joystick = new Joystick(RobotMap.JOYSTICK);

    Button shoot = new JoystickButton(joystick, 1);
    shoot.whenPressed(new ShootHatch());

    Button changeVelcro = new JoystickButton(joystick, 2);
    changeVelcro.whenPressed(new ChangeVelcroState());

    Button bamBam = new JoystickButton(joystick, 7);
    bamBam.whenPressed(new ExtendHatchGrabber());

    Button retract = new JoystickButton(joystick, 8);
    retract.whenPressed(new ResetHatchGrabber());

    Button unwindWench = new POVButton(joystick, 0);
    unwindWench.whileHeld(new ExtendClimberArm());
    unwindWench.whenReleased(new ArmStop());

    Button windWench = new POVButton(joystick, 180);
    windWench.whileHeld(new RetractClimberArm());
    windWench.whenReleased(new ArmStop());

    Button latch = new JoystickButton(joystick, 3);
    latch.whenPressed(new Latch());

    Button release = new JoystickButton(joystick, 4);
    release.whenPressed(new Release());
  }

  public Joystick getJoystick() {
    return joystick;
  }
}
