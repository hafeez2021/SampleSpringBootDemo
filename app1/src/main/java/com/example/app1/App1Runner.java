package com.example.app1;

import contracts.Car;
import org.springframework.stereotype.Component;

@Component
public class App1Runner {

    public App1Runner(Car car)
    {
       System.out.println(String.format("From App1 with %s", car.getModel()));
    }
}
