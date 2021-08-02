package implementation;

import contracts.Brake;
import contracts.Car;
import contracts.Engine;

public class CarToyota implements Car {

    private final Brake brake;
    private final Engine engine;

    public CarToyota(Brake brake, Engine engine)
    {
        this.brake = brake;
        this.engine = engine;
    }

    public String getModel() {
        return "Toyota Car with " + this.brake.get() + "," + this.engine.get();
    }
}
