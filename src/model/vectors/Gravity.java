package model.vectors;

public class Gravity implements Force{

    private final int acceleration;

    public Gravity(int acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void apply(Body body, int deltaTime) {
        body.setYLinearVelocity(body.getYLinearVelocity() + acceleration * deltaTime);
    }
}
