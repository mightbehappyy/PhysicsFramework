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


    private Shape2D shape2D;
    private Vector vector;
    private List<Force> forces = new ArrayList<>();
    private final ShapesEnum shapesEnum;
    private final int mass;

    public RigidBody(ShapesEnum shape, int xPosition, int yPosition, int height, int width, int mass) {
        this.vector = new Vector(xPosition, yPosition, height);
        this.shape2D =  ShapeFactory.createShape2D(shape, this.vector, height, width);
        this.shapesEnum = shape;
        this.mass = mass;
    }

    public RigidBody(ShapesEnum shape, int xPosition, int yPosition, int diameter, int mass) {
        this.vector = new Vector(xPosition, yPosition, diameter);
        this.shape2D =  ShapeFactory.createShape2D(shape, new Vector(xPosition, yPosition, diameter), diameter, diameter);
        this.shapesEnum = shape;
        this.mass = mass;
    }

    public void instantiate() {
        Scene.getInstance().addObject(this);
    }

    public void update(double deltaTime) {

        vector.setXPosition(vector.getXPosition() + vector.getXLinearVelocity());
        vector.setYPosition(vector.getYPosition() + vector.getYLinearVelocity());
        if (vector.getYPosition() >= 500) {
            vector.setYPosition(500);
        }
        System.out.println(vector.getYPosition());

        this.shape2D =  ShapeFactory.createShape2D(
                shapesEnum,
                vector,
                (int)getShape2D().getShape().getBounds2D().getHeight(),
                (int)getShape2D().getShape().getBounds2D().getWidth()
                );

        applyForces(deltaTime);
    }

    public void applyForces(double deltaTime) {
        for (Force force : forces) {
            force.apply(vector, deltaTime);
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