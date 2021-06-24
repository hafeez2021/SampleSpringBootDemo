package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.Engine;

public class CarToyota implements Car {

    private final Brake brake;
    private final Engine engine;

    public CarToyota(Brake brake, Engine engine)
    {

        this.brake = brake;
        this.engine = engine;
    }

    public void model() {
        System.out.println("Toyota Car with " + this.brake.get() + "," + this.engine.get());
    }
}
