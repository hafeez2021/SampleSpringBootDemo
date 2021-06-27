package com.dp.demo;

import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.PersistenceRepository;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner {

    public DemoRunner(Car car, PersistenceRepository persistenceRepository)
    {
        persistenceRepository.executeSql("select * from");
        car.model();
    }
}
