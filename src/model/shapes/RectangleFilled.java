package model.shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleFilled extends Rectangle {

    public RectangleFilled() {
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
