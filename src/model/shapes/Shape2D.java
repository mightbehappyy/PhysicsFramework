package model.shapes;

import model.vectors.Vector;

import java.awt.*;

public abstract class Shape2D {
    protected Shape shape;
    protected Vector vector;
    protected Color color;
    public Shape2D() {

    }

    public abstract void setShape(int width, int height);

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
        g.setColor(Color.BLACK);
        g.draw(shape);
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Shape getShape() {
        return shape;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}