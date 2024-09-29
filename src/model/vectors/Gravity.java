package model.vectors;

import model.vectors.interfaces.Force;

public class Gravity implements Force {

    private final int acceleration;

    public Gravity(int acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void apply(Vector vector, int deltaTime) {
        vector.setYLinearVelocity(vector.getYLinearVelocity() + acceleration * deltaTime);
    }
}
