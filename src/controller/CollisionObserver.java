package controller;

import model.bodies.RigidBody;
import model.enums.ShapesEnum;
import model.scenes.Scene;
import model.vectors.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CollisionObserver {

    public CollisionObserver instance = null;
    public Scene scene;
    public List<RigidBody> observers = new ArrayList<>();

    public CollisionObserver(Scene scene) {
        this.scene = scene;
    }



    public void addObserver(RigidBody rigidBody) {
        observers.add(rigidBody);
    }

    public void checkForCollision() {

        for (RigidBody rigidBody : scene.getDrawableBodies()) {
            rigidBody.setColliding(false);
        }

        for (int i = 0; i < scene.getDrawableBodies().size(); i++) {
            RigidBody rigidBody = scene.getDrawableBodies().get(i);
            for (int j = i + 1; j < scene.getDrawableBodies().size(); j++) {
                RigidBody otherRigidBody = scene.getDrawableBodies().get(j);
                if (isColliding(rigidBody, otherRigidBody)) {
                    if (!rigidBody.isColliding() && !otherRigidBody.isColliding()) {
                        rigidBody.setColliding(true);
                        otherRigidBody.setColliding(true);
                        double[] newVelocities = calculateFinalVelocities(rigidBody, otherRigidBody);

                        rigidBody.setVectorXVelocity(newVelocities[0]);
                        rigidBody.setVectorYVelocity(newVelocities[1]);
                        otherRigidBody.setVectorXVelocity(newVelocities[2]);
                        otherRigidBody.setVectorYVelocity(newVelocities[3]);
                    }
                }
            }
        }
    }


    public double[] calculateFinalVelocities(RigidBody rigidBody, RigidBody otherRigidBody) {
        double m1 = rigidBody.getMass();
        double m2 = otherRigidBody.getMass();

        double v1x = rigidBody.getVector().getXLinearVelocity();
        double v1y = rigidBody.getVector().getYLinearVelocity();
        double v2x = otherRigidBody.getVector().getXLinearVelocity();
        double v2y = otherRigidBody.getVector().getYLinearVelocity();

        double newVelocity1X = ((m1 - m2) * v1x + 2 * m2 * v2x) / (m1 + m2);
        double newVelocity1Y = ((m1 - m2) * v1y + 2 * m2 * v2y) / (m1 + m2);

        double newVelocity2X = ((m2 - m1) * v2x + 2 * m1 * v1x) / (m1 + m2);
        double newVelocity2Y = ((m2 - m1) * v2y + 2 * m1 * v1y) / (m1 + m2);

        return new double[] { newVelocity1X, newVelocity1Y, newVelocity2X, newVelocity2Y };
    }


    public Boolean isColliding(RigidBody rigidBody, RigidBody otherRigidBody) {
        if (rigidBody.getShapesEnum() == ShapesEnum.CIRCLE && otherRigidBody.getShapesEnum() == ShapesEnum.CIRCLE) {
            return checkCircleCircleCollision(rigidBody, otherRigidBody);
        }

        if (rigidBody.getShapesEnum() == ShapesEnum.SQUARE && otherRigidBody.getShapesEnum() == ShapesEnum.SQUARE) {
            return checkSquareSquareCollision(rigidBody, otherRigidBody);
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
        double distSquared = distX * distX + distY * distY;

        double radius1 = rigidBody.getShape2D().getShape().getBounds2D().getWidth() / 2;
        double radius2 = otherRigidBody.getShape2D().getShape().getBounds2D().getWidth() / 2;

        double radiiSum = radius1 + radius2;
        return distSquared <= (radiiSum * radiiSum);
    }


    public boolean checkSquareSquareCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        return rigidBody.getShape2D().getShape().intersects(otherRigidBody.getShape2D().getShape().getBounds());
    }

    public boolean checkCircleSquareCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        Shape circle = rigidBody.getShape2D().getShape();
        Shape square = otherRigidBody.getShape2D().getShape();
        Vector circleVector = rigidBody.getVector();
        Vector squareVector = otherRigidBody.getVector();


        double circleX = circleVector.getXPosition();
        double circleY = circleVector.getYPosition();
        double circleRadius = circle.getBounds2D().getWidth() / 2;


        double squareX = squareVector.getXPosition();
        double squareY = squareVector.getYPosition();
        double squareWidth = square.getBounds2D().getWidth();
        double squareHeight = square.getBounds2D().getHeight();


        double closestX = Math.max(squareX, Math.min(circleX, squareX + squareWidth));
        double closestY = Math.max(squareY, Math.min(circleY, squareY + squareHeight));


        double distX = circleX - closestX;
        double distY = circleY - closestY;
        double distanceSquared = (distX * distX) + (distY * distY);


        boolean collision = distanceSquared <= (circleRadius * circleRadius);

        return collision;
    }





}
