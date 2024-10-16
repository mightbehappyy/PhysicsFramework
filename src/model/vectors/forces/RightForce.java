package model.vectors.forces;

import model.vectors.Vector;
import model.vectors.interfaces.IForce;

public class RightForce implements IForce {

    private double acceleration;

    public RightForce() {

    }

    @Override
    public void apply(Vector vector, double deltaTime) {
        vector.setXLinearVelocity(vector.getXLinearVelocity() + acceleration * deltaTime);
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
}
