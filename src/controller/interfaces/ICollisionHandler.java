package controller.interfaces;

import model.bodies.RigidBody;

public interface ICollisionHandler {
    boolean checkCollision(RigidBody rigidBody1, RigidBody rigidBody2);
}
