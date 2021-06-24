package com.dp.demo;

import com.dp.demo.contracts.Car;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner {

    public DemoRunner(Car car)
    {
        car.model();
    }
}
