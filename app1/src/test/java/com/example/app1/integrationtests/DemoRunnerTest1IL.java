package com.example.app1.integrationtests;


import com.example.app1.App1Runner;
import com.example.app1.configuration.ContextConfiguration1;
import com.example.app1.dependencyconfig.PersistenceConfig;
import com.example.app1.dependencyconfig.ServiceConfig;
import contracts.Car;
import contracts.StorageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;

//Method1: Integration Test methods
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class,
                                    ContextConfiguration1.class},
        loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTest1IL {

    @Autowired
    private Car car;

    @Autowired
    private StorageConfig storageConfig;

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        App1Runner demoApplication = new App1Runner(car);
        verify(storageConfig,times(2)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageConfig.getConnectionString());

    }

}

