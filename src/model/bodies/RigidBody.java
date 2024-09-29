package model.bodies;

import controller.ShapeFactory;
import model.enums.ShapesEnum;
import model.scenes.Scene;
import model.shapes.Shape2D;
import model.vectors.Vector;
import model.vectors.interfaces.Force;

import java.util.ArrayList;
import java.util.List;

public class RigidBody {

    private List<Force> forces = new ArrayList<>();
    private final Shape2D shape2D;

    public RigidBody(ShapesEnum shape, int xPosition, int yPosition, int height, int width, int mass) {
        this.shape2D =  ShapeFactory.createShape2D(shape, new Vector(xPosition, yPosition, height), height, width);
    }

    public RigidBody(ShapesEnum shape, int xPosition, int yPosition, int diameter, int mass) {
        this.shape2D =  ShapeFactory.createShape2D(shape, new Vector(xPosition, yPosition, diameter), diameter, diameter);
    }

    public void instantiate() {
        Scene.getInstance().addObject(this);
    }

    public void applyForces(int deltaTime) {
        for (Force force : forces) {
            force.apply(getShape2D().getBody(), deltaTime);
        }
    }

    public void addForce(Force force) {
        forces.add(force);
    }

    public List<Force> getForces() {
        return forces;
    }

    public Shape2D getShape2D() {
        return shape2D;
    }
}