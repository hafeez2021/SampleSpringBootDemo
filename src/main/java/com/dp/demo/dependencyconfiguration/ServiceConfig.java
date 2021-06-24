package com.dp.demo.dependencyconfiguration;

import com.dp.demo.contracts.*;
import com.dp.demo.implementation.BrakeBrembo;
import com.dp.demo.implementation.CarHonda;
import com.dp.demo.implementation.EngineHonda;
import com.dp.demo.implementation.PadHard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dp.demo")
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
