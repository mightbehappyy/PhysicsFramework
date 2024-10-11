package model.scenes;

import controller.CollisionObserver;
import model.bodies.RigidBody;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scene {
    private final List<RigidBody> drawableBodies;
    private static Scene instance = null;

    private Scene() {
        this.drawableBodies = new ArrayList<>();
    }

    public static Scene getInstance() {
        if (instance == null) {
            instance = new Scene();
        }
        return instance;
    }

    public void addObject(RigidBody body) {
        drawableBodies.add(body);
    }

    public void drawAllBodies(Graphics2D graphics) {
        for (RigidBody body : drawableBodies) {
            body.getShape2D().draw(graphics);
        }
    }

    public List<RigidBody> getDrawableBodies() {
        return drawableBodies;
    }
}