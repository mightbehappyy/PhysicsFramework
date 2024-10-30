package controller;

import controller.collisions.CircleCircleCollisionHandler;
import controller.collisions.CircleSquareCollisionHandler;
import controller.collisions.SquareSquareCollisionHandler;
import controller.interfaces.ICollisionHandler;
import model.bodies.RigidBody;
import model.enums.ShapesEnum;

import java.util.Map;

public class CollisionHandlerFactory {

    private final static Map<ShapesEnum, Map<ShapesEnum, ICollisionHandler>> handlerMap = Map.of(
            ShapesEnum.CIRCLE, Map.of(
                    ShapesEnum.CIRCLE, new CircleCircleCollisionHandler(),
                    ShapesEnum.SQUARE, new CircleSquareCollisionHandler()
            ),
            ShapesEnum.SQUARE, Map.of(
                    ShapesEnum.CIRCLE, new CircleSquareCollisionHandler(),
                    ShapesEnum.SQUARE, new SquareSquareCollisionHandler()
            )
    );

    public static ICollisionHandler getHandler(RigidBody rigidBody1, RigidBody rigidBody2) {
        ShapesEnum shape1 = normalizeShape(rigidBody1.getShapesEnum());
        ShapesEnum shape2 = normalizeShape(rigidBody2.getShapesEnum());

        return handlerMap
                .getOrDefault(shape1, Map.of())
                .getOrDefault(shape2, new CircleCircleCollisionHandler());
    }

    private static ShapesEnum normalizeShape(ShapesEnum shape) {
        return switch (shape) {
            case CIRCLEFILLED -> ShapesEnum.CIRCLE;
            case SQUAREFILLED -> ShapesEnum.SQUARE;
            case RECTANGLEFILLED -> ShapesEnum.RECTANGLE;
            default -> shape;
        };
    }
}