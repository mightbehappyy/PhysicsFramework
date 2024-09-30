package model.shapes;

import model.vectors.Vector;

import java.awt.*;

public abstract class Shape2D {
    protected Shape shape;
    protected Vector vector;

    public Shape2D() {

    }

    public abstract void setShape(int width, int height);

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public void draw(Graphics2D g) {
        g.draw(getShape());
    }

    public Shape getShape() {
        return shape;
    }
}