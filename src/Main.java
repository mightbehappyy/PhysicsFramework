import model.bodies.RigidBody;
import model.shapes.Circle;
import model.shapes.Square;
import model.vectors.Body;
import view.Simulation;

public class Main {
    public static void main(String[] args) {
        new Simulation();
        Body body = new Body(300, 50, 1);
        Circle circle = new Circle(body, 10);
        RigidBody rigidBody = new RigidBody(circle);
        rigidBody.instanciate();

        Body body2 = new Body(500, 50, 1);
        Square square = new Square(10, body2);
        RigidBody rigidBody2 = new RigidBody(square);
        rigidBody2.instanciate();
    }
}