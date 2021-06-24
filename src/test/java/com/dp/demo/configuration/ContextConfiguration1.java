package com.dp.demo.configuration;

import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;
import static org.mockito.Mockito.when;

@Configuration
public class ContextConfiguration1
{
    @Bean
    public StorageAccountConfig storageAccountConfig()
    {
        StorageAccountConfig storageAccountConfig = Mockito.mock(StorageAccountConfig.class);
        when(storageAccountConfig.getConnectionString()).thenReturn("Mock Storage Account Config");
        return storageAccountConfig;
    }
}