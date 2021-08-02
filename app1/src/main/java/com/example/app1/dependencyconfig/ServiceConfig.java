package com.example.app1.dependencyconfig;

import contracts.*;
import implementation.BrakeBrembo;
import implementation.CarHonda;
import implementation.EngineHonda;
import implementation.PadHard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class ServiceConfig {

    @Bean
    public Engine engine() {
        return new EngineHonda("v8", 5);
    }

    @Bean
    public Pad pad() {
        return new PadHard();
    }

    @Bean
    public Brake brake(Pad pad, Persistence persistence) {
        return new BrakeBrembo(pad, persistence);
    }

    @Bean
    public Car car(Engine engine, Brake brake)
    {
        return new CarHonda(brake, engine);
    }
}
