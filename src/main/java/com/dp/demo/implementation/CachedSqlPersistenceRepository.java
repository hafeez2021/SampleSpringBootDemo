package com.dp.demo.implementation;

import com.dp.demo.contracts.PersistenceRepository;
import com.dp.demo.contracts.QueryableRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CachedSqlPersistenceRepository implements QueryableRepository {

    private final PersistenceRepository queryableRepository;

    // Use thread safe collection
    private List<String> someCache;

    public CachedSqlPersistenceRepository(PersistenceRepository queryableRepository)
    {
        this.queryableRepository = queryableRepository;
        load();
    }

    @Override
    public void insert(String i) {

        if(!someCache.contains(i))
        {
            queryableRepository.insert(i);
            someCache.add(i);
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
