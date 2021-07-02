package com.dp.demo.implementation;

import com.dp.demo.contracts.MappingTableSchema;
import com.dp.demo.contracts.QueryableRepository;

public class MappingTableRepository<T extends MappingTableSchema> {

    private final Class<T> type;
    private final QueryableRepository queryableRepository;

    public MappingTableRepository(Class<T> type, QueryableRepository queryableRepository) {
        this.type = type;
        this.queryableRepository = queryableRepository;
    }

    public String Get()
    {
        return type.toString();
    }

    public void insert(String level)
    {
        //Validations for checking both columns are unique
            //return
        //Validation Unique ID is unique
            // Write to your Error File
            // return;
        //Validation ProxyID is unique
            // Write to your Error File
            //return;
        queryableRepository.insert(level);
    }

}



