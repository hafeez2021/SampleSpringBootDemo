package com.dp.demo.implementation;

import com.dp.demo.contracts.PersistenceRepository;
import org.springframework.jdbc.core.JdbcOperations;

public class PersistenceRepositorySql implements PersistenceRepository {

    private final JdbcOperations jdbcOperations;

    public PersistenceRepositorySql(JdbcOperations jdbcOperations)
    {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void executeSql(String s) {

    }

    @Override
    public void execute(String sql) {

    }

    @Override
    public String dropTableQueryIfExists(String fullTableName) {
        return null;
    }

    @Override
    public String dropSchemaIfExists(String schemaName) {
        return null;
    }
}
