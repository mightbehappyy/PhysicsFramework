package model.shapes;

import model.vectors.Body;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape2D {

    public Circle(Body body, int diameter) {
        super(diameter, diameter, body);
    }

    @Override
    public void draw(Graphics2D g) {
        g.draw(getShape());
    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Ellipse2D.Double(getBody().getXPosition(), getBody().getYPosition(), width, height);
    }
}
