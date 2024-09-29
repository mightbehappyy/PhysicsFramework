package model.shapes;

import model.vectors.Body;

import java.awt.*;

public abstract class Shape2D {
    private final Body body;
    protected Shape shape;

    public Shape2D(int width, int height, Body body) {
        this.body = body;
        setShape(width, height);
    }

    public abstract void draw(Graphics g);

    public abstract void setShape(int width, int height);

    public Body getBody() {
        return body;
    }

}
