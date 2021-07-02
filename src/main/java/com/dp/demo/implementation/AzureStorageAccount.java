package com.dp.demo.implementation;

import com.dp.demo.contracts.StorageAccount;

import java.nio.file.Path;

public class AzureStorageAccount implements StorageAccount {
    @Override
    public void downloadMetadata() {

    }

    @Override
    public Path getMetadataPath() {
        return null;
    }
}
