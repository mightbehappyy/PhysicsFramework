package controller;
import model.enums.ShapesEnum;
import model.shapes.*;

import java.awt.*;
import java.util.Map;

import model.shapes.Rectangle;
import model.vectors.Vector;

public class ShapeFactory {

    private final Map<ShapesEnum, Shape2D> shapesMap = Map.of(
            ShapesEnum.CIRCLE, new Circle(),
            ShapesEnum.SQUARE, new Square(),
            ShapesEnum.RECTANGLE, new Rectangle(),
            ShapesEnum.CIRCLEFILLED, new CircleFilled(),
            ShapesEnum.SQUAREFILLED, new SquareFilled(),
            ShapesEnum.RECTANGLEFILLED, new RectangleFilled()
    );

    public ShapeFactory() {

    }

    public Shape2D createShape2D(ShapesEnum shape, Color color, Vector vector, int height, int width) {
        Shape2D newShape =  shapesMap.get(shape);
        newShape.setVector(vector);
        newShape.setShape(width, height);
        newShape.setColor(color);
        return newShape;
    }
}