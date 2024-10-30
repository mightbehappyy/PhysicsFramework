package controller.collisions;

import controller.interfaces.ICollisionHandler;
import model.bodies.RigidBody;
import model.vectors.Vector;

import java.awt.*;

public class CircleSquareCollisionHandler implements ICollisionHandler {

    @Override
    public boolean checkCollision(RigidBody rigidBody1, RigidBody rigidBody2) {
        Shape circle = rigidBody1.getShape2D().getShape();
        Shape square = rigidBody2.getShape2D().getShape();
        Vector circleVector = rigidBody1.getVector();
        Vector squareVector = rigidBody2.getVector();

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
