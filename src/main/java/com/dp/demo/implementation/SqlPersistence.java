package com.dp.demo.implementation;

import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import com.dp.demo.contracts.Persistence;

public class SqlPersistence implements Persistence {

    private final StorageAccountConfig storageAccountConfig;

    public SqlPersistence(StorageAccountConfig storageAccountConfig)
    {
        this.storageAccountConfig = storageAccountConfig;
    }
    public String get() {
        return "SQL with conn string: "+ storageAccountConfig.getConnectionString();
    }
}
