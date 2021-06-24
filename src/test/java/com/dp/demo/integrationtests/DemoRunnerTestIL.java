package com.dp.demo;


import com.dp.demo.configuration.ContextConfiguration1;
import com.dp.demo.contracts.Car;
import com.dp.demo.dependencyconfiguration.PersistenceConfig;
import com.dp.demo.dependencyconfiguration.ServiceConfig;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class,
                                    ContextConfiguration1.class},
        loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTestIL {

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Test
    public void newTest()
    {
        DemoRunner demoApplication = new DemoRunner(car);
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

}

