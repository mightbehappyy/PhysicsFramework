package model.shapes;

import model.vectors.Vector;

import java.awt.geom.Ellipse2D;

public class Circle extends Shape2D {

    public Circle() {

    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Ellipse2D.Double(getBody().getXPosition(), getBody().getYPosition(), width, height);
    }
}