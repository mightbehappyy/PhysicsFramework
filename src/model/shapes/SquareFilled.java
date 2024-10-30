package model.shapes;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class SquareFilled extends Square {

    public SquareFilled() {
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
