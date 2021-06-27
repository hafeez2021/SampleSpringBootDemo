package com.dp.demo.contracts;

public interface PersistenceRepository {
    void executeSql(String s);

    void execute(String sql);

    String dropTableQueryIfExists(String fullTableName);

    String dropSchemaIfExists(String schemaName);
}
