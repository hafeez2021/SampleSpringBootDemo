package com.dp.demo.dependencyconfiguration;

import com.dp.demo.contracts.*;
import com.dp.demo.implementation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.dp.demo")
public class ServiceConfig {

    @Bean
    public Engine engine() {
        return new EngineHonda("v8", 5);
    }

    @Bean
    public Pad pad() {
        return new PadHard();
    }

    @Bean
    public Brake brake(Pad pad, @Qualifier("bloomFilterRepository") QueryableRepository queryableRepository) {
        return new BrakeBrembo(pad, queryableRepository);
    }

    @Bean
    public Car car(Engine engine, Brake brake)
    {
        return new CarHonda(brake, engine);
    }

    @Bean
    public Persistence persistence(StorageAccountConfig storageAccountConfig) {
        return new SqlPersistence(storageAccountConfig);
    }

    @Bean("bloomFilterRepository")
    public QueryableRepository querableRepository(@Qualifier("cachedRepository")  QueryableRepository persistenceRepository) {
        return new BloomFilterPersistenceRepository(persistenceRepository);
    }

    @Bean("cachedRepository")
    public QueryableRepository querableRepository(@Qualifier("dbPersistenceRepository")  PersistenceRepository persistenceRepository) {
        return new CachedSqlPersistenceRepository(persistenceRepository);
    }

    @Bean("dbPersistenceRepository")
    public PersistenceRepository persistenceRepository() {
        return new SqlPersistenceRepository();
    }
}
