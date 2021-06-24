package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.Engine;
import org.springframework.stereotype.Service;

public class CarHonda implements Car {

    private final Brake brake;
    private final Engine engine;

    public CarHonda(Brake brake, Engine engine)
    {
        this.brake = brake;
        this.engine = engine;
    }

    public void model() {
        String output = "Honda Car with " + this.brake.get() + "," + this.engine.get();
        System.out.println(output);
    }
}
