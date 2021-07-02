package com.dp.demo.implementation;

import com.dp.demo.contracts.MetadataRepository;
import com.dp.demo.implementation.DemoSchema;

import java.nio.file.Path;
import java.util.List;

public class DatasetSchemaRepository implements MetadataRepository {

    @Override
    public List<DemoSchema> parse(Path downloadedPath) {
        return null;
    }
}
