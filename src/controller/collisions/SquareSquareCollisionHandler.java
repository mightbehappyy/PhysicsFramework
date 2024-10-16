package controller.collisions;

import controller.interfaces.ICollisionHandler;
import model.bodies.RigidBody;

public class SquareSquareCollisionHandler implements ICollisionHandler {
    @Override
    public boolean checkCollision(RigidBody rigidBody1, RigidBody rigidBody2) {
        return rigidBody1.getShape2D().getShape().intersects(rigidBody2.getShape2D().getShape().getBounds());
    }
}