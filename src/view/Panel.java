package view;

import model.scenes.Scene;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {

    private final int frameLimitation;

    public Panel(int frameLimitation) {
        this.frameLimitation = frameLimitation;
    }

    public void paintComponent(Graphics g) {
        long startTime = System.currentTimeMillis();
        super.paintComponent(g);

        Scene.getInstance().getDrawableBodies().forEach(p -> p.getShape2D().draw((Graphics2D) g));

        limitUpdate(startTime, frameLimitation);
        repaint();
    }

    public void limitUpdate(long startTime, int frameLimit) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long waitTime = (1000 / frameLimit) - elapsedTime;
        if (waitTime > 0) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}