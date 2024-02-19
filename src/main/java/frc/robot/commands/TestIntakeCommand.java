package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OperatorConstants.ControllerConstants;
import frc.robot.subsystems.intake.IntakeSubsytem;
import frc.robot.util.ControlHandler;
import frc.robot.controllers.AbstractController;

public class TestIntakeCommand extends Command {
    private final IntakeSubsytem intake;
    private final AbstractController joystick;

    public TestIntakeCommand(IntakeSubsytem intake, AbstractController joystick) {
        this.intake = intake;
        this.joystick = joystick;

        addRequirements(intake);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (ControlHandler.get(joystick, ControllerConstants.RUN_INTAKE).getAsBoolean()) {
            this.intake.setIntakeSpeed(1, 1);
        } else if (ControlHandler.get(joystick, ControllerConstants.REVERSE_INTAKE).getAsBoolean()) {
            this.intake.setIntakeSpeed(-0.2, -0.2);
        } else {
            this.intake.setIntakeSpeed(0, 0);
        }

        this.intake.setPivotSpeed(-joystick.getRightVerticalMovement());

        // System.out.println("intake position: " + Util.nearestHundredth(intake.getPivotPosition()));

        // System.out.println("lower intake current: " + this.intake.getFollowerMotorCurrent() + ", top current: " + this.intake.getLeaderMotorCurrent());
    }

    // Called once the command ends or is interrupted.
    @Override
     public void end(boolean interrupted) {

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
