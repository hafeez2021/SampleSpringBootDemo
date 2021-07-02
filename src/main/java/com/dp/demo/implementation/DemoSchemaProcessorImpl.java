package com.dp.demo.implementation;

import com.dp.demo.contracts.DemoSchemaProcessor;
import com.dp.demo.contracts.PersistenceRepository;

public class DemoSchemaProcessorImpl implements DemoSchemaProcessor {
    private final PersistenceRepository persistenceRepository;

    public DemoSchemaProcessorImpl(PersistenceRepository persistenceRepository)
    {

        this.persistenceRepository = persistenceRepository;
    }
    @Override
    public void process(DemoSchema demoSchema) {
        //demoSc
        persistenceRepository.select();
    }
}
