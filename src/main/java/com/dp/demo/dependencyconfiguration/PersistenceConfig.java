package com.dp.demo.dependencyconfiguration;

import com.dp.demo.contracts.*;
import com.dp.demo.implementation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dp.demo")
public class PersistenceConfig {

    @Bean
    public Persistence persistence(StorageAccountConfig storageAccountConfig) {
        return new SqlPersistence(storageAccountConfig);
    }
}
