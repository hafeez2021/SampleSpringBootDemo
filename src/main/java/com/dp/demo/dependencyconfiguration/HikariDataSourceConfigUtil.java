package com.dp.demo.dependencyconfiguration;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.env.Environment;

public final class HikariDataSourceConfigUtil {
    public static HikariConfig setDataSourceEnvConfig(String prefix1, String prefix, Environment env) {

        HikariConfig config = new HikariConfig();
        String driver = env.getProperty(prefix1 + "driver-class-name");
        String dataSourceUrl = env.getProperty(prefix1 + "jdbcUrl");
        String user = env.getProperty(prefix1 + "username");
        String password = env.getProperty(prefix1 + "password");
        String minimumIdle = env.getProperty(prefix + "minimumIdle");
        String maximumPoolSize = env.getProperty(prefix + "maximumPoolSize");
        String autoCommit = env.getProperty(prefix + "autoCommit");
        String idleTimeout = env.getProperty(prefix + "idleTimeout");
        String poolName = env.getProperty(prefix + "poolName");
        String maxLifetime = env.getProperty(prefix + "maxLifetime");
        String connectionTimeout = env.getProperty(prefix + "connectionTimeout");
        String dataSourceClassName = env.getProperty(prefix + "type");
        
        if (!StringUtils.isEmpty(dataSourceUrl)) {
            config.setJdbcUrl(dataSourceUrl);
        }

        if (!StringUtils.isEmpty(dataSourceClassName)) {
            config.setDataSourceClassName(dataSourceClassName);
        }

        if (!StringUtils.isEmpty(user)) {
            config.setUsername(user);
        }
        if (!StringUtils.isEmpty(password)) {
            config.setPassword(password);
        }
        if (!StringUtils.isEmpty(driver)) {
            config.setDriverClassName(driver);
        }

        if (!StringUtils.isEmpty(minimumIdle)) {
            config.setMinimumIdle(Integer.parseInt(minimumIdle));
        }
        if (!StringUtils.isEmpty(maximumPoolSize)) {
            config.setMaximumPoolSize(Integer.parseInt(maximumPoolSize));
        }
        if (!StringUtils.isEmpty(autoCommit)) {
            config.setAutoCommit(Boolean.parseBoolean(autoCommit));
        }
        if (!StringUtils.isEmpty(idleTimeout)) {
            config.setIdleTimeout(Integer.parseInt(idleTimeout));
        }
        if (!StringUtils.isEmpty(poolName)) {
            config.setPoolName(poolName);
        }
        if (!StringUtils.isEmpty(maxLifetime)) {
            config.setMaxLifetime(Integer.parseInt(maxLifetime));
        }
        if (!StringUtils.isEmpty(connectionTimeout)) {
            config.setConnectionTimeout(Integer.parseInt(connectionTimeout));
        }
        return config;
    }
}
