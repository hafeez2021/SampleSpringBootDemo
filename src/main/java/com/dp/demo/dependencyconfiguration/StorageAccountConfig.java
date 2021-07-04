package com.dp.demo.dependencyconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.*;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "app.storage-account")
public class StorageAccountConfig {
    @ToString.Exclude
    private String connectionString;

    public StorageAccountConfig()
    {

    }
}
