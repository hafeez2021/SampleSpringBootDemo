package com.dp.demo.dependencyconfiguration;

import com.dp.demo.contracts.PersistenceRepository;
import com.dp.demo.implementation.PersistenceRepositorySql;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static com.dp.demo.dependencyconfiguration.HikariDataSourceConfigUtil.setDataSourceEnvConfig;

@Configuration
public class DatabaseConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    public DataSource dataSource(Environment environment) {
       HikariConfig hikariConfig =  HikariDataSourceConfigUtil.setDataSourceEnvConfig("app.datasource.","",environment);

       HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
       DataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
       return dataSource;
    }

    @Bean
    public PersistenceRepository persistenceRepository(DataSource dataSource)
    {
        JdbcOperations jdbcOperations = new JdbcTemplate(dataSource);
        return new PersistenceRepositorySql(jdbcOperations);
    }
}
