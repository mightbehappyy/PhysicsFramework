import model.bodies.RigidBody;
import model.enums.ShapesEnum;
import model.vectors.Gravity;
import view.Simulation;

public class Main {
    public static void main(String[] args) {
        new Simulation();

        RigidBody rigidBody = new RigidBody(ShapesEnum.CIRCLE, 0, 550, 30, 5);
        rigidBody.addForce(new Gravity(9.8));
        rigidBody.setVectorXVelocity(2.0);
        rigidBody.setVectorYVelocity(-6.0);
        rigidBody.instantiate();

        RigidBody rigidBody2 = new RigidBody(ShapesEnum.SQUARE, 0, 550, 30, 5);
        rigidBody2.addForce(new Gravity(9.8));
        rigidBody2.setVectorXVelocity(0.5);
        rigidBody2.setVectorYVelocity(-6.0);
        rigidBody2.instantiate();


    }
}