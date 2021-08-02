package implementation;


import contracts.Persistence;
import contracts.StorageConfig;

public class SqlPersistence implements Persistence {

    private final StorageConfig storageAccountConfig;

    public SqlPersistence(StorageConfig storageAccountConfig)
    {
        this.storageAccountConfig = storageAccountConfig;
    }
    public String get() {
        return "SQL with conn string: "+ storageAccountConfig.getConnectionString();
    }
}
