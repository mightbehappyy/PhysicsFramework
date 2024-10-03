package controller;

import controller.interfaces.ICollisionObserver;
import model.bodies.RigidBody;
import model.enums.ShapesEnum;
import model.scenes.Scene;
import model.vectors.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionObserver {

    public Scene scene;
    public List<ICollisionObserver> observers = new ArrayList<>();

    public CollisionObserver(Scene scene) {
        this.scene = scene;
    }

    public void checkForCollision() {
        for (int i = 0; i < scene.getDrawableBodies().size(); i++) {
            for (int j = 0; j < scene.getDrawableBodies().size(); j++) {
                RigidBody rigidBody = scene.getDrawableBodies().get(i);
                RigidBody otherRigidBody = scene.getDrawableBodies().get(j);
                if (rigidBody != otherRigidBody & isColliding(rigidBody, otherRigidBody)) {
                    System.out.println("Collision Detected");
                }
            }
        }
    }

    public Boolean isColliding(RigidBody rigidBody, RigidBody otherRigidBody) {
        if (rigidBody.getShapesEnum() == ShapesEnum.CIRCLE && otherRigidBody.getShapesEnum() == ShapesEnum.CIRCLE) {
            return checkCircleCircleCollision(rigidBody, otherRigidBody);
        }

        if (rigidBody.getShapesEnum() == ShapesEnum.SQUARE && otherRigidBody.getShapesEnum() == ShapesEnum.SQUARE) {
            return rigidBody.getShape2D().getShape().intersects(rigidBody.getShape2D().getShape().getBounds());
        }

        if (rigidBody.getShapesEnum() == ShapesEnum.CIRCLE && otherRigidBody.getShapesEnum() == ShapesEnum.SQUARE) {
            return checkCircleSquareCollision(rigidBody, otherRigidBody);
        }
        if (rigidBody.getShapesEnum() == ShapesEnum.SQUARE && otherRigidBody.getShapesEnum() == ShapesEnum.CIRCLE) {
            return checkCircleSquareCollision(otherRigidBody, rigidBody);
        }

        return false;
    }

    public boolean checkCircleCircleCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        double distX = rigidBody.getVector().getXPosition() - otherRigidBody.getVector().getXPosition();
        double distY = rigidBody.getVector().getYPosition() - otherRigidBody.getVector().getYPosition();
        double dist = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
        return dist <= rigidBody.getShape2D().getShape().getBounds2D().getWidth() + otherRigidBody.getShape2D().getShape().getBounds2D().getWidth();
    }

    public boolean checkSquareSquareCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        return rigidBody.getShape2D().getShape().intersects(rigidBody.getShape2D().getShape().getBounds());
    }

    public boolean checkCircleSquareCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        Shape circle = rigidBody.getShape2D().getShape();
        Shape square = otherRigidBody.getShape2D().getShape();
        Vector circleVector = rigidBody.getVector();
        Vector squareVector = otherRigidBody.getVector();

        double testX = rigidBody.getVector().getXPosition();
        double testY = rigidBody.getVector().getYPosition();

        if (circleVector.getXPosition() < squareVector.getXPosition()) testX = squareVector.getXPosition();
        else if (circleVector.getXPosition() > squareVector.getXPosition() + square.getBounds2D().getWidth()) {
            testX = squareVector.getXPosition() + square.getBounds2D().getWidth();
        }

        if (circleVector.getYPosition() < squareVector.getYPosition()) testY = squareVector.getYPosition();
        else if (circleVector.getYPosition() > squareVector.getYPosition() + square.getBounds2D().getHeight()) {
            testY = squareVector.getYPosition() + square.getBounds2D().getHeight();
        }
        double distX = circleVector.getXPosition() - testX;
        double distY = circleVector.getYPosition() - testY;
        double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

        return distance <= circle.getBounds2D().getWidth();
    }
}
