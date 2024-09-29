package model.vectors;

public class Body {
    private int xPosition;
    private int yPosition;
    private int xLinearVelocity;
    private int yLinearVelocity;
    private final int mass;

    public Body(int xPosition, int yPosition, int mass) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.mass = mass;
        this.xLinearVelocity = 0;
        this.yLinearVelocity = 0;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getXLinearVelocity() {
        return xLinearVelocity;
    }

    public int getYLinearVelocity() {
        return yLinearVelocity;
    }

    public int getMass() {
        return mass;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public void setXLinearVelocity(int xLinearVelocity) {
        this.xLinearVelocity = xLinearVelocity;
    }
    public void setYLinearVelocity(int yLinearVelocity) {
        this.yLinearVelocity = yLinearVelocity;
    }

}
