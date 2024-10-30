package model.vectors;

public class Vector {
    private double xPosition;
    private double yPosition;
    private double xLinearVelocity;
    private double yLinearVelocity;

    public Vector(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public double getXLinearVelocity() {
        return xLinearVelocity;
    }

    public double getYLinearVelocity() {
        return yLinearVelocity;
    }

    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(double yPosition) {
        this.yPosition = yPosition;
    }
    public void setXLinearVelocity(double xLinearVelocity) {
        this.xLinearVelocity = xLinearVelocity;
    }
    public void setYLinearVelocity(double yLinearVelocity) {
        this.yLinearVelocity = yLinearVelocity;
    }

}