package com.example.app1.dependencyconfig;

import contracts.Persistence;
import contracts.StorageConfig;
import implementation.SqlPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class PersistenceConfig {

    @Bean
    public Persistence persistence(StorageConfig storageConfig) {
        return new SqlPersistence(storageConfig);
    }
}
