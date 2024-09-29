package model.scenes;

import model.bodies.RigidBody;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<RigidBody> drawableBodies;

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
    public List<RigidBody> getDrawableBodies() {
        return drawableBodies;
    }
}