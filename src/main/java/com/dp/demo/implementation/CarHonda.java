package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.Engine;

public class CarHonda implements Car {

    private final Brake brake;
    private final Engine engine;

    public CarHonda(Brake brake, Engine engine)
    {

        this.brake = brake;
        this.engine = engine;
    }

    public String description() {
        String description = model() + " Car with " + this.brake.get() + "," + this.engine.get();
        return description;
    }

    @Override
    public String model() {
        return "Honda City";
    }
}
