package model.shapes;

import model.vectors.Vector;

import java.awt.geom.Rectangle2D;

public class Square extends Shape2D{

    public Square() {

    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Rectangle2D.Double
                (getBody().getXPosition(), getBody().getYPosition(), width, height);
    }
}