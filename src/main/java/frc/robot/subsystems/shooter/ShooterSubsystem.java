
package frc.robot.subsystems.shooter;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import frc.robot.Constants.LauncherConstants;
import com.revrobotics.RelativeEncoder;
//import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;

//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase
  {

    private final CANSparkMax rSpark = new CANSparkMax(Constants.ShooterConstants.rightShooterCanId, MotorType.kBrushless);
    private final CANSparkMax lSpark = new CANSparkMax(Constants.ShooterConstants.leftShooterCanId, MotorType.kBrushless);
    
    public void spin() {
        //spark.setVoltage(SmartDashboard.getNumber("Spin voltage", 0));
        rSpark.setVoltage(4);
        lSpark.setVoltage(4);

    }

    public void stopSpin() {
        rSpark.set(0);
        lSpark.set(0);
    }

    public void hold() {
        rSpark.setVoltage(SmartDashboard.getNumber("Hold voltage", 0));
        lSpark.setVoltage(SmartDashboard.getNumber("Hold voltage", 0));
    }

    public void actuate() {

    }

    public Command spinCommand() {
        return run(this::spin).finallyDo((interrupted)->stopSpin());

    }

    public Command holdCommand() {
        return run(this::hold);
    }

    public Command stopSpinCommand() {
        return runOnce(this::stopSpin);
    }

  }

