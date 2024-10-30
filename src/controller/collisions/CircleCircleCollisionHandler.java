package controller.collisions;

import controller.interfaces.ICollisionHandler;
import model.bodies.RigidBody;

public class CircleCircleCollisionHandler implements ICollisionHandler {
    
    @Override
    public boolean checkCollision(RigidBody rigidBody1, RigidBody rigidBody2) {
        double distX = rigidBody1.getVector().getXPosition() - rigidBody2.getVector().getXPosition();
        double distY = rigidBody1.getVector().getYPosition() - rigidBody2.getVector().getYPosition();
        double distSquared = distX * distX + distY * distY;

        double radius1 = rigidBody1.getShape2D().getShape().getBounds2D().getWidth() / 2;
        double radius2 = rigidBody2.getShape2D().getShape().getBounds2D().getWidth() / 2;

        double radiiSum = radius1 + radius2;
        return distSquared <= (radiiSum * radiiSum);
    }
}
