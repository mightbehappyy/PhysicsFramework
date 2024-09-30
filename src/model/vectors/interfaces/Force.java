package model.vectors.interfaces;

import model.vectors.Vector;

public interface Force {
    void apply(Vector vector, double deltaTime);
}
