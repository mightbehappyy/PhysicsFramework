import model.bodies.RigidBody;
import model.enums.ShapesEnum;
import model.vectors.Gravity;
import view.Simulation;

public class Main {
    public static void main(String[] args) {
        new Simulation();

        RigidBody rigidBody = new RigidBody(ShapesEnum.CIRCLE, 300, 0, 5, 5);
        rigidBody.addForce(new Gravity(9.8));
        rigidBody.instantiate();

        RigidBody rigidBody2 = new RigidBody(ShapesEnum.SQUARE, 400, 0, 20, 5);
        rigidBody2.addForce(new Gravity(9.8));
        rigidBody2.instantiate();

    }
}