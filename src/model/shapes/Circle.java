package model.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape2D {

    public Circle() {
        super();
    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Ellipse2D.Double(vector.getXPosition(), vector.getYPosition(), width, height);
    }
}