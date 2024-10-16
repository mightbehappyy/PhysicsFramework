package service;

import model.bodies.RigidBody;


public class PhysicsMethods {

    public static void obliqueLaunch(RigidBody rigidBody, int angle, double initialVelocity) {
        double angleInRadians = Math.toRadians(angle);
        double sine = Math.sin(angleInRadians);
        double cos = Math.cos(angleInRadians);
        double xVelocity = cos * (initialVelocity);
        double yVelocity = (sine * initialVelocity) * Math.signum(initialVelocity);

        rigidBody.getVector().setXLinearVelocity(xVelocity);
        rigidBody.getVector().setYLinearVelocity(-yVelocity);
    }

    public static void resolveCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
            double[] newVelocities = elasticCollision(rigidBody, otherRigidBody);
            rigidBody.getVector().setXLinearVelocity(newVelocities[0]);
            rigidBody.getVector().setYLinearVelocity(newVelocities[1]);
            otherRigidBody.getVector().setXLinearVelocity(newVelocities[2]);
            otherRigidBody.getVector().setYLinearVelocity(newVelocities[3]);
    }

    private static double[] elasticCollision(RigidBody rigidBody, RigidBody otherRigidBody) {
        double m1 = rigidBody.getMass();
        double m2 = otherRigidBody.getMass();

        double v1x = rigidBody.getVector().getXLinearVelocity();
        double v1y = rigidBody.getVector().getYLinearVelocity();
        double v2x = otherRigidBody.getVector().getXLinearVelocity();
        double v2y = otherRigidBody.getVector().getYLinearVelocity();

        double newVelocity1X = ((m1 - m2) * v1x + 2 * m2 * v2x) / (m1 + m2);
        double newVelocity1Y = ((m1 - m2) * v1y + 2 * m2 * v2y) / (m1 + m2);

        double newVelocity2X = ((m2 - m1) * v2x + 2 * m1 * v1x) / (m1 + m2);
        double newVelocity2Y = ((m2 - m1) * v2y + 2 * m1 * v1y) / (m1 + m2);

        return new double[] { newVelocity1X, newVelocity1Y, newVelocity2X, newVelocity2Y };
    }
}