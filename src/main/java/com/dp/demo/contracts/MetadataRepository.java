package com.dp.demo.contracts;

import com.dp.demo.implementation.DemoSchema;

import java.nio.file.Path;
import java.util.List;

public interface MetadataRepository {
    List<DemoSchema> parse(Path downloadedPath);
}

