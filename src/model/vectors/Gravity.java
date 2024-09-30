package model.vectors;

import model.vectors.interfaces.Force;

public class Gravity implements Force {

    private final double acceleration;

    public Gravity(double acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void apply(Vector vector, double deltaTime) {
        vector.setYLinearVelocity(vector.getYLinearVelocity() + acceleration * deltaTime);
    }
}
