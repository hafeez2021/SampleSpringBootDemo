package com.dp.demo.implementation;

import com.dp.demo.contracts.DemoSchemaProcessor;
import com.dp.demo.contracts.MetadataRepository;
import com.dp.demo.contracts.StorageAccount;
import com.dp.demo.implementation.DemoSchema;

import java.nio.file.Path;
import java.util.List;

public class ParentProcessor {
    private final MetadataRepository metadataRepository;
    private final StorageAccount storageAccount;
    private final DemoSchemaProcessor demoSchemaProcessor;

    public ParentProcessor(MetadataRepository metadataRepository, StorageAccount storageAccount, DemoSchemaProcessor demoSchemaProcessor)
    {
        this.metadataRepository = metadataRepository;
        this.storageAccount = storageAccount;
        this.demoSchemaProcessor = demoSchemaProcessor;
    }

    public void process()
    {
        storageAccount.downloadMetadata();
       Path downloadedPath = storageAccount.getMetadataPath();
       List<DemoSchema> demoSchemas = metadataRepository.parse(downloadedPath);

        for (DemoSchema demoSchema: demoSchemas) {
            demoSchemaProcessor.process(demoSchema);
        }
    }
}
