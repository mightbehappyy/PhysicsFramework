package model.shapes;

import model.vectors.Body;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape2D {

    public Circle(Body body, int diameter) {
        super(diameter, diameter, body);
    }

    @Override
    public void draw(Graphics g) {
        g.fillOval(
                getBody().getXPosition(),
                getBody().getYPosition(),
                (int) shape.getBounds2D().getHeight(),
                (int) shape.getBounds2D().getHeight()
        );
    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Ellipse2D.Double(getBody().getXPosition(), getBody().getYPosition(), width, height);
    }
}
