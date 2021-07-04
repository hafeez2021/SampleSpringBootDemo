package com.dp.demo;

import com.dp.demo.contracts.Car;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import com.dp.demo.models.HubMappingTableSchema;
import com.dp.demo.models.NRICMappingTableSchema;
import com.dp.demo.contracts.QueryableRepository;
import com.dp.demo.implementation.MappingTableRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("!test")
public class DemoRunner implements CommandLineRunner {


    private final Car car;
    private final QueryableRepository queryableRepository;
    private final StorageAccountConfig storageAccountConfig;

    public DemoRunner(Car car, @Qualifier("bloomFilterRepository")  QueryableRepository queryableRepository, StorageAccountConfig storageAccountConfig)
    {

        this.car = car;
        this.queryableRepository = queryableRepository;
        this.storageAccountConfig = storageAccountConfig;
    }

    @Override
    public void run(String... args) {
        System.out.println(car.description());


/*         System.out.println(storageAccountConfig.getConnectionString());

        MappingTableRepository nricMappingTable = new MappingTableRepository(NRICMappingTableSchema.class, queryableRepository);
        System.out.println(nricMappingTable.Get());

        MappingTableRepository hubMappingTable = new MappingTableRepository(HubMappingTableSchema.class, queryableRepository);
        System.out.println(hubMappingTable.Get());*/
    }
}
