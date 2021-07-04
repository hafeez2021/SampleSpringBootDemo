package com.dp.demo.implementation;

import com.dp.demo.contracts.Brake;
import com.dp.demo.contracts.Pad;
import com.dp.demo.contracts.Persistence;
import com.dp.demo.contracts.QueryableRepository;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;

public class BrakeBrembo implements Brake {

    private final Pad pad;
    private final QueryableRepository queryableRepository;
    private final StorageAccountConfig storageAccountConfig;

    public BrakeBrembo(Pad pad, QueryableRepository queryableRepository, StorageAccountConfig storageAccountConfig)
    {
        this.pad = pad;
        this.queryableRepository = queryableRepository;
        this.storageAccountConfig = storageAccountConfig;
    }

    public String get() {
        return "Brembo " + "with Pad:" +pad.get() + " From Persistence:" + queryableRepository.select() + " " + storageAccountConfig.getConnectionString();
    }
}
