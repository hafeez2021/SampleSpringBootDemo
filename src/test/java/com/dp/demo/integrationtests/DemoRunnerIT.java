package com.dp.demo.integrationtests;


import com.dp.demo.DemoRunner;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.QueryableRepository;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

public class DemoRunnerIT extends DemoRunnerIntegrationTestBaseSetup {

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        DemoRunner demoApplication = new DemoRunner(car, Mockito.mock(QueryableRepository.class), storageAccountConfig);
        demoApplication.run();
        verify(storageAccountConfig,times(1)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

}

