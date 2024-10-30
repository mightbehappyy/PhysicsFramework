package model.bodies;

import controller.CollisionManager;
import controller.ShapeFactory;
import model.enums.ForceEnum;
import model.enums.ShapesEnum;
import model.scenes.Scene;
import model.shapes.Shape2D;
import model.vectors.Vector;
import model.vectors.forces.ForceManager;
import model.vectors.interfaces.IForce;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static view.Frame.HEIGHT;

public class RigidBody {

    private Shape2D shape2D;
    private final Vector vector;
    private final List<IForce> IForces = new ArrayList<>();
    private final ShapesEnum shapesEnum;
    private final int mass;
    private Color color;

    public RigidBody(ShapesEnum shape, Color color, int xPosition, int yPosition, int height, int width, int mass) {
        this.vector = new Vector(xPosition, yPosition);
        this.shape2D =  new ShapeFactory().createShape2D(shape,color, vector, height, width);
        this.shapesEnum = shape;
        this.mass = mass;
    }

    public RigidBody(ShapesEnum shape, Color color, int xPosition, int yPosition, int size, int mass) {
        this.vector = new Vector(xPosition, yPosition);
        this.color = color;
        this.shape2D =  new ShapeFactory().createShape2D(shape, color, vector, size, size);
        this.shapesEnum = shape;
        this.mass = mass;
    }

    public void instantiate() {
        Scene.getInstance().addObject(this);
    }

    public void update(double deltaTime) {

        this.vector.setXPosition(this.vector.getXPosition() + this.vector.getXLinearVelocity());
        this.vector.setYPosition(this.vector.getYPosition() + this.vector.getYLinearVelocity());

        if (this.vector.getYPosition() >= HEIGHT  - this.getShape2D().getShape().getBounds().height) {
            vector.setYLinearVelocity(0);
            vector.setYPosition(HEIGHT  - this.getShape2D().getShape().getBounds().height);
        }

        this.shape2D =  new ShapeFactory().createShape2D(
                shapesEnum,
                color,
                this.vector,
                (int)getShape2D().getShape().getBounds2D().getHeight(),
                (int)getShape2D().getShape().getBounds2D().getWidth()
                );
        applyForces(deltaTime);
    }

    public void applyForces(double deltaTime) {
        for (IForce IForce : IForces) {
            IForce.apply(vector, deltaTime);
        }
    }

    public void addForce(ForceEnum force, double acceleration) {
        IForces.add(new ForceManager().getForce(force, acceleration));
    }

    public void setCollisionOn() {
        CollisionManager.getInstance().addCollidableBody(this);
    }

    public void setCollisionOff() {
        CollisionManager.getInstance().removeCollidableBody(this);
    }

    public List<IForce> getForces() {
        return IForces;
    }

    public Shape2D getShape2D() {
        return shape2D;
    }

    public Vector getVector() {
        return this.vector;
    }

    public int getMass() {
        return mass;
    }

    public ShapesEnum getShapesEnum() {
        return shapesEnum;
    }
}