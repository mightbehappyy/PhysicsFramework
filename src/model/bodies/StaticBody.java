package model.bodies;

import model.enums.ShapesEnum;

import java.awt.*;

public class StaticBody extends RigidBody{

    public StaticBody(ShapesEnum shape, Color color, int xPosition, int yPosition, int size, int mass) {
        super(shape, color, xPosition, yPosition, size, mass);
    }

    public StaticBody(ShapesEnum shape, Color color, int xPosition, int yPosition, int height, int width, int mass) {
        super(shape, color, xPosition, yPosition, height, width, mass);
    }
}
