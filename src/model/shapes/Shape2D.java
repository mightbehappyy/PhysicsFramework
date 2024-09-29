package model.shapes;

import model.vectors.Vector;

import java.awt.*;

public abstract class Shape2D {
    private Vector vector;
    protected Shape shape;

    public Shape2D() {

    }

    public void draw(Graphics2D g) {
        g.draw(getShape());
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public abstract void setShape(int width, int height);

    public Vector getBody() {
        return vector;
    }

    public Shape getShape() {
        return shape;
    }
}