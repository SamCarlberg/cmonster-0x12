package frc.robot.subsystems.climber;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase{
      private final CANSparkMax leftSpark =
      new CANSparkMax(Constants.ClimberConstants.climberLeftSpark, MotorType.kBrushless);

      private final CANSparkMax rightSpark = new CANSparkMax(Constants.ClimberConstants.climberRightSpark, MotorType.kBrushless);

      public void startClimb() {
        // spark.setVoltage(SmartDashboard.getNumber("Spin voltage", 0));
        rightSpark.set(Constants.ClimberConstants.climberSpeed);
        leftSpark.set(Constants.ClimberConstants.reverseClimberSpeed);
      }

      public void reverseClimb() {
        rightSpark.set(Constants.ClimberConstants.reverseClimberSpeed);
        leftSpark.set(Constants.ClimberConstants.climberSpeed);
      }

      public void stopClimb() {
        leftSpark.set(0);
        rightSpark.set(0);
      }

      public Command climbCommand() {
        return run(this::startClimb).finallyDo(interrupted -> stopClimb());
      }

      public Command reverseClimbCommand() {
        return run(this::reverseClimb).finallyDo(interrupted -> stopClimb());
      }

      public Command stopClimbCommand() {
        return runOnce(this::stopClimb);
      }
}
