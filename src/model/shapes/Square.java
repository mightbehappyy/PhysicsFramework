package model.shapes;

import model.vectors.Body;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape2D{

    public Square(int side, Body body) {
        super(side, side, body);

    }

    @Override
    public void draw(Graphics2D g) {
        g.draw(getShape());
    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Rectangle2D.Double
                (getBody().getXPosition(), getBody().getYPosition(), width, height);
    }
}
