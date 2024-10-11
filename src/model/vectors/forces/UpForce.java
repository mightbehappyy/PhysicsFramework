package model.vectors.forces;

import model.vectors.Vector;
import model.vectors.interfaces.IForce;

public class UpForce implements IForce {

    private double acceleration;

    public UpForce() {

    }

    @Override
    public void apply(Vector vector, double deltaTime) {
        vector.setYLinearVelocity(vector.getYLinearVelocity() - acceleration * deltaTime);
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
}
