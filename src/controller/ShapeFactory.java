package controller;

import model.enums.ShapesEnum;
import model.shapes.Circle;
import model.shapes.Shape2D;

import java.util.HashMap;
import java.util.Map;

import model.shapes.Square;
import model.vectors.Vector;

public class ShapeFactory {

    private static final Map<ShapesEnum, Shape2D> shapesMap = Map.of(
            ShapesEnum.CIRCLE, new Circle(),
            ShapesEnum.SQUARE, new Square()
    );

    public static Shape2D createShape2D(ShapesEnum shape, Vector vector, int height, int width) {
        Shape2D newShape =  shapesMap.getOrDefault(shape, shapesMap.get(ShapesEnum.CIRCLE));
        newShape.setVector(vector);
        newShape.setShape(width, height);
        return newShape;
    }
}
