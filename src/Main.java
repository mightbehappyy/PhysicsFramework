    import model.bodies.RigidBody;
    import model.enums.ForceEnum;
    import model.enums.ShapesEnum;

    import view.Simulation;

    import java.awt.*;

    public class Main {
        public static void main(String[] args) {
            new Simulation();

            RigidBody rigidBody2 = new RigidBody(ShapesEnum.SQUARE, Color.WHITE,10, 550, 30, 10);
            rigidBody2.setVectorYVelocity(-5);
            rigidBody2.addForce(ForceEnum.DOWN, 9.8);
            rigidBody2.instantiate();

            RigidBody rigidBody3 = new RigidBody(ShapesEnum.CIRCLE, Color.BLUE, 450, 300, 30, 5);
            rigidBody3.addForce(ForceEnum.DOWN, 9.8);
            rigidBody3.setVectorXVelocity(0);
            rigidBody3.instantiate();
        }
    }