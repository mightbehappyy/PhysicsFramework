package controller;

import model.bodies.RigidBody;
import model.scenes.Scene;
import service.PhysicsMethods;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager {

    private final List<RigidBody> collideableBodies = new ArrayList<>();
    private static CollisionManager instance = null;

    public CollisionManager() {
    }

    public static CollisionManager getInstance() {
        if (instance == null) {
            instance = new CollisionManager();
        }
        return instance;
    }

    public void addCollidableBody(RigidBody rigidBody) {
        collideableBodies.add(rigidBody);
    }
    
    public void removeCollidableBody(RigidBody rigidBody) {
        collideableBodies.remove(rigidBody);
    }
    
    public void checkForCollision() {
        for (int i = 0; i < collideableBodies.size(); i++) {
            RigidBody rigidBody = collideableBodies.get(i);
            for (int j = i + 1; j < collideableBodies.size(); j++) {
                RigidBody otherRigidBody = collideableBodies.get(j);
                    if (isColliding(rigidBody, otherRigidBody)) {
                        PhysicsMethods.resolveCollision(rigidBody, otherRigidBody);
                    }
            }
        }
    }

    public Boolean isColliding(RigidBody rigidBody, RigidBody otherRigidBody) {
        return CollisionHandlerFactory
                .getHandler(rigidBody, otherRigidBody)
                .checkCollision(rigidBody, otherRigidBody);
    }
}