    import model.bodies.RigidBody;
    import model.enums.ForceEnum;
    import model.enums.ShapesEnum;

    import service.PhysicsMethods;
    import view.Simulation;

    import java.awt.*;

    public class Main {
        public static void main(String[] args) {
            new Simulation();

            RigidBody rigidBody4 = new RigidBody(ShapesEnum.CIRCLEFILLED, Color.BLACK,20, 850, 20, 100);
            rigidBody4.instantiate();
            rigidBody4.addForce(ForceEnum.DOWN, 9.8);
            rigidBody4.setCollisionOn();
            PhysicsMethods.obliqueLaunch(rigidBody4, 70, 5);
        }
    }