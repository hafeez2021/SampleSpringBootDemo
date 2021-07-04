package com.dp.demo.integrationtests;


import com.dp.demo.DemoRunner;
import com.dp.demo.configuration.ContextMockConfiguration;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.QueryableRepository;
import com.dp.demo.dependencyconfiguration.PersistenceConfig;
import com.dp.demo.dependencyconfiguration.ServiceConfig;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;

//Method1: Integration Test methods
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class,
                                    ContextMockConfiguration.class},
        loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTest1IL {

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        DemoRunner demoApplication = new DemoRunner(car , Mockito.mock(QueryableRepository.class), storageAccountConfig);
        verify(storageAccountConfig,times(2)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

}

