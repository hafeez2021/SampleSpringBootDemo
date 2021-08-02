package com.example.app1.configuration;

import com.example.app1.dependencyconfig.StorageAccountConfig;
import contracts.StorageConfig;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.when;

@Configuration
public class ContextConfiguration1
{
    @Bean
    public StorageConfig storageAccountConfig()
    {
        StorageConfig storageAccountConfig = Mockito.mock(StorageAccountConfig.class);
        when(storageAccountConfig.getConnectionString()).thenReturn("Mock Storage Account Config");
        return storageAccountConfig;
    }
}