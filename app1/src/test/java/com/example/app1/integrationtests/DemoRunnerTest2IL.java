package com.example.app1.integrationtests;

import com.example.app1.App1Runner;
import com.example.app1.dependencyconfig.PersistenceConfig;
import com.example.app1.dependencyconfig.ServiceConfig;
import com.example.app1.dependencyconfig.StorageAccountConfig;
import contracts.Car;
import contracts.StorageConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;

//Method2: Integration Test methods
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTest2IL {

    @Configuration
    static class ContextConfiguration
    {
        @Bean
        public StorageConfig storageAccountConfig()
        {
            StorageConfig storageAccountConfig = Mockito.mock(StorageAccountConfig.class);
            when(storageAccountConfig.getConnectionString()).thenReturn("Mock Storage Account Config2");
            return storageAccountConfig;
        }
    }

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        App1Runner demoApplication = new App1Runner(car);
        verify(storageAccountConfig,times(2)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

}

