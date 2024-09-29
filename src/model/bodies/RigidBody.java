package model.bodies;

import model.scenes.Scene;
import model.shapes.Shape2D;
import model.vectors.Force;

import java.util.ArrayList;
import java.util.List;

public class RigidBody {

    private List<Force> forces = new ArrayList<>();
    private final Shape2D shape;

    public RigidBody(Shape2D shape) {
        this.shape = shape;
    }

    public void instanciate() {
        Scene.getInstance().addObject(this);
    }

    public void applyForces(int deltaTime) {
        for (Force force : forces) {
            force.apply(getShape().getBody(), deltaTime);
        }
    }

    public void addForce(Force force) {
        forces.add(force);
    }

    public List<Force> getForces() {
        return forces;
    }
    public Shape2D getShape() {
        return shape;
    }

}
