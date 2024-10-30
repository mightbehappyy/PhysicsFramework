package model.vectors.forces;

import model.enums.ForceEnum;
import model.vectors.Vector;
import model.vectors.interfaces.IForce;

import java.util.Map;

public class ForceManager {

    private final Map<ForceEnum, IForce> forceMap = Map.of(
            ForceEnum.UP, new UpForce(),
            ForceEnum.RIGHT, new RightForce(),
            ForceEnum.DOWN, new Gravity(),
            ForceEnum.LEFT, new LeftForce()
    );

    public ForceManager() {

    }
    
    public IForce getForce(ForceEnum forceEnum, double acceleration) {
        IForce force = forceMap.get(forceEnum);
        force.setAcceleration(acceleration);
        return force;
    }
}
