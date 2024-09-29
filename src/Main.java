import model.bodies.RigidBody;
import model.enums.ShapesEnum;
import model.shapes.Circle;
import model.shapes.Square;
import model.vectors.Vector;
import view.Simulation;

public class Main {
    public static void main(String[] args) {
        new Simulation();

        RigidBody rigidBody = new RigidBody(ShapesEnum.CIRCLE, 300, 50, 30, 5);
        rigidBody.instantiate();

        RigidBody rigidBody2 = new RigidBody(ShapesEnum.SQUARE, 600, 100, 10, 5);
        rigidBody2.instantiate();
    }
}