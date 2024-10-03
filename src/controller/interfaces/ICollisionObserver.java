package controller.interfaces;

import model.bodies.RigidBody;

public interface ICollisionObserver {
    public void onCollision(RigidBody rigidBody1, RigidBody rigidBody2);
}
