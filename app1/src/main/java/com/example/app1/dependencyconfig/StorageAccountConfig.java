package com.example.app1.dependencyconfig;

import contracts.StorageConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.*;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "app.storage-account")
public class StorageAccountConfig implements StorageConfig {
    @ToString.Exclude
    private String connectionString;

    public StorageAccountConfig()
    {

    }
}
