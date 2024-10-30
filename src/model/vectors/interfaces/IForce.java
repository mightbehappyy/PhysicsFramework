package model.vectors.interfaces;

import model.vectors.Vector;

public interface IForce {
    void apply(Vector vector, double deltaTime);
    void setAcceleration(double acceleration);
}
