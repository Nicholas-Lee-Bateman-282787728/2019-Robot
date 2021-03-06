package frc.team4931.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team4931.robot.Robot;
import frc.team4931.robot.commands.hatchgrabber.ExtendVelcro;
import frc.team4931.robot.commands.hatchgrabber.ResetHatchGrabber;
import frc.team4931.robot.commands.hatchgrabber.RetractVelcro;
import frc.team4931.robot.commands.lineup.LineupWithTarget;
import frc.team4931.robot.commands.utilities.DriveForward;

public class GetHatchAuto extends CommandGroup {
  public GetHatchAuto() {
    setInterruptible(true);

    addSequential(new LineupWithTarget(true));
    
    addSequential(new ResetHatchGrabber());

    addSequential(new ExtendVelcro());

    addSequential(new DriveForward(0.30, 1000));

    addSequential(new RetractVelcro());

    addSequential(new DriveForward(-0.30, 1000));
  }

  @Override
  protected void execute() {
    Joystick joy = Robot.getOperatorInput().getJoystick();
    boolean bool = Math.abs(joy.getX()) > 0.2 || Math.abs(joy.getY()) > 0.2 || Math.abs(joy.getZ()) > 0.2;

    if (bool)
      cancel();
  }

  @Override
  protected void interrupted() {
    Robot.getHatchGrabber().retractVelcro();
  }
}
