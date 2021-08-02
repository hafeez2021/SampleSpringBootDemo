package implementation;

import contracts.Brake;
import contracts.Car;
import contracts.Engine;

public class CarHonda implements Car {

    private final Brake brake;
    private final Engine engine;

    public CarHonda(Brake brake, Engine engine)
    {
        this.brake = brake;
        this.engine = engine;
    }

    public String getModel() {
        return"Honda Car with " + this.brake.get() + "," + this.engine.get();
    }
}
