# FRC2018

Code for Team 6141's 2018 Power Up Robot

## Packages

### Robot
Contains:
#### Robot
    Main Robot Class that is used connect others classes. Has mostly unused methods for auto/teleop/test init and periodic

#### OI
    All the joystick and xbox controls are contained in here. Maps buttons to commands and contains helper methods for commands

#### Robot Const
    Stores most of the constant values in a single class for easy access and updating

### Subsystems
Contains:
#### RobotControl
    Master Subsystem that stores all others. Used to reduce code in Robot Class. Instantiates all contained subsystems and contains         methodsfor sending smartdashboard updates to all substituaries. 

#### DriveTrain
    Controls the main robot drivetrain. Contains instantiated drivetrain motors (VictorSp) and methods to control them
    Important Methods:
- setSpeed: sets drivetrain motor speeds. Requres: leftSpeed, rightSpeed doubles
- setSpeedAndTurn: calculates leftSpeed and rightSpeed, then calls setSpeed() with values. Requires: speed, turn doubles
- update: prints current motor speeds to SmartDashboard

#### Intake
    Controls the Claw Intake System. Contains instantiated claw motors (Spark) and methods to control them
    Important Methods:
- setSpeed: sets claw motor speeds. Requres: leftSpeed, rightSpeed doubles
- setSpeedAndTurn: calculates leftSpeed and rightSpeed, then calls setSpeed() with values. Requires: speed, turn doubles
- stop: stops motors
- update: prints current motor speeds to SmartDashboard

#### Elevator
    Controls the Up/Down Elevator that carries claw. Containts instantiated elevator motor (Spark) and methods to control it
    Important Methods:
- setSpeed: sets elevator motor speed. Requires speed double
- stop: stops motor
- update: prints current motor speed to SmartDashboard
        
  
  
