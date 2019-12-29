package frc.robot;


public class visionDriveCalculate {

    public visionDriveCalculate () {

    }

    public tankDriveOrder getSpeedRequest(double visionAngle, double gyroAngle, double targetAngle, double targetDistance, double averagePower) {
        
        //calculate angled distance and straight distance
        double errorAngle = gyroAngle - targetAngle;
        double firstDriveDistance = stage1DriveDistance(targetDistance, visionAngle, errorAngle);
        double secondDriveDistance = stage2DriveDistance(targetDistance, visionAngle, errorAngle);

         //compare, return average power if angled is greater than straight
        if (firstDriveDistance >= secondDriveDistance) {
            return new tankDriveOrder(averagePower, averagePower);
        }

        //calculate radius
        double radius = driveRadius(firstDriveDistance, errorAngle);

        //calculate power differential and return
        return powerDifferential(averagePower, radius, RobotMap.DRIVE_BASE_WIDTH_CM);
    }

    private double stage1DriveDistance (double targetDistance, double visionAngle, double errorAngle) {
        return (targetDistance * Math.sin(Math.toRadians(errorAngle - visionAngle))) / Math.sin(Math.toRadians(180 - errorAngle));
    }

    private double stage2DriveDistance (double targetDistance, double visionAngle, double errorAngle) {
        return (targetDistance * Math.sin(Math.toRadians(visionAngle))) / Math.sin(Math.toRadians(180 - errorAngle));
    }

    private double driveRadius(double firstDrive, double sectorAngle) {
        return (firstDrive)*(Math.tan(Math.toRadians((180 - sectorAngle) / 2)));
    }

    private tankDriveOrder powerDifferential(double centerSpeed, double radius, double driveBase) {
        double leftPower = centerSpeed * (1 - (driveBase / (2 * radius)));
        double rightPower = centerSpeed * (1 + (driveBase / (2 * radius)));
        return new tankDriveOrder(leftPower, rightPower);
    }
}