package com.dp.demo.integrationtests;


import com.dp.demo.DemoRunner;
import com.dp.demo.configuration.ContextConfiguration1;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.PersistenceRepository;
import com.dp.demo.dependencyconfiguration.PersistenceConfig;
import com.dp.demo.dependencyconfiguration.ServiceConfig;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;

//Method2: Integration Test methods
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTest2IL {

    @Configuration
    static class ContextConfiguration
    {
        @Bean
        public StorageAccountConfig storageAccountConfig()
        {
            StorageAccountConfig storageAccountConfig = Mockito.mock(StorageAccountConfig.class);
            when(storageAccountConfig.getConnectionString()).thenReturn("Mock Storage Account Config2");
            return storageAccountConfig;
        }
    }

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Autowired
    private PersistenceRepository persistenceRepository;

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        DemoRunner demoApplication = new DemoRunner(car, persistenceRepository);
        verify(storageAccountConfig,times(2)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

}

