package model.shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape2D {

    public Rectangle(){

    }

    @Override
    public void setShape(int width, int height) {
        this.shape = new Rectangle2D.Double(vector.getXPosition(), vector.getYPosition(), width, height);
    }

}