package com.dp.demo;

import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.HubMappingTableSchema;
import com.dp.demo.contracts.NRICMappingTableSchema;
import com.dp.demo.contracts.QueryableRepository;
import com.dp.demo.implementation.MappingTableRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner {


    public DemoRunner(Car car, @Qualifier("bloomFilterRepository")  QueryableRepository queryableRepository)
    {
        System.out.println(car.model());
        System.out.println(car.description());

        MappingTableRepository nricMappingTable = new MappingTableRepository(NRICMappingTableSchema.class, queryableRepository);
        System.out.println(nricMappingTable.Get());

        MappingTableRepository hubMappingTable = new MappingTableRepository(HubMappingTableSchema.class, queryableRepository);
        System.out.println(hubMappingTable.Get());
    }
}
