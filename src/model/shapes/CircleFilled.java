package model.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleFilled extends Circle {

    public CircleFilled() {
        super();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
        g.setColor(Color.BLACK);
        g.draw(shape);
    }
}
