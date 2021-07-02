package com.dp.demo.implementation;

import com.dp.demo.contracts.QueryableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BloomFilterPersistenceRepository implements QueryableRepository {

    private final QueryableRepository queryableRepository;

    // Use thread safe collection
    private List<String> someCache; //BloomFilter

    public BloomFilterPersistenceRepository(QueryableRepository queryableRepository)
    {
        this.queryableRepository = queryableRepository;
        load();
    }

    @Override
    public void insert(String i) {

        if(!someCache.contains(i))
        {
            someCache.add(i);
            queryableRepository.insert(i);
        }
    }

    @Override
    public List<String> select() {
        return someCache.stream().collect(Collectors.toList());
    }

    private void load() {
        someCache = new ArrayList<>();
        someCache.addAll(queryableRepository.select());
    }
}
