package view;

import controller.CollisionObserver;
import model.scenes.Scene;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {

    private final int frameLimit;
    private final CollisionObserver collisionObserver;

    public Panel(int frameLimit) {
        this.frameLimit = frameLimit;
        this.collisionObserver = new CollisionObserver(Scene.getInstance());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Scene.getInstance().drawAllBodies((Graphics2D) g);
        repaint();
    }

    public void gameLoop() {
        long lastTime = System.currentTimeMillis();
        double timePerFrame = 1000.0 / frameLimit;

        while (true) {
            long currentTime = System.currentTimeMillis();
            double deltaTime = (currentTime - lastTime) / 1000.0;
            lastTime = currentTime;

            updatePhysics(deltaTime);
            limitFrameRate(currentTime, timePerFrame);
        }
    }

    private void updatePhysics(double deltaTime) {
        Scene.getInstance().getDrawableBodies().forEach(body -> {
            body.update(deltaTime);
        });
        collisionObserver.checkForCollision();
    }

    private void limitFrameRate(long startTime, double timePerFrame) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long waitTime = (long) (timePerFrame - elapsedTime);

        if (waitTime > 0) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}