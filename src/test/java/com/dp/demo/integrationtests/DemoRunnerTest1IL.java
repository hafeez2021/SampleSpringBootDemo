package com.dp.demo.integrationtests;


import com.dp.demo.DemoRunner;
import com.dp.demo.configuration.ContextConfiguration1;
import com.dp.demo.contracts.Car;
import com.dp.demo.contracts.PersistenceRepository;
import com.dp.demo.dependencyconfiguration.DatabaseConfig;
import com.dp.demo.dependencyconfiguration.PersistenceConfig;
import com.dp.demo.dependencyconfiguration.ServiceConfig;
import com.dp.demo.dependencyconfiguration.StorageAccountConfig;
import com.dp.demo.utils.TestFileSetupHelper;
import com.dp.demo.utils.TestResources;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import static org.mockito.Mockito.*;


//Method1: Integration Test methods
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@TestPropertySource(properties = {"app.datasource.jdbcUrl=jdbc:sqlserver://HAFEEZ_DELL:1433;databaseName=testdb",
        "app.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver",
        "app.datasource.username=testadmin",
        "app.datasource.password=ABCD@1234",
        "app.datasource.initialization-mode=never",
        "app.datasource.platform=mssql"})
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class,
                                    ContextConfiguration1.class,
                                    DatabaseConfig.class},
                    loader = AnnotationConfigContextLoader.class)
public class DemoRunnerTest1IL {

    private static final int EXTREME_LOAD = 1000000; // 5m records
    private static final Random RANDOM = new Random(1234567890L);
    private static final int LIMIT = 99999999;

    @Autowired
    private Car car;

    @Autowired
    private  StorageAccountConfig storageAccountConfig;

    @Autowired
    private PersistenceRepository persistenceRepository;

    @Before
    public void setUp() throws IOException {
        boolean skip = true;

        if(skip)
            return;

        final int numFiles = 5;

        for (int i = 1; i <= numFiles; i++) {
            final String suffix = EXTREME_LOAD + "_" + i;
            String testCsvFilePath = TestResources.getFilePath("extreme_load_test_" + suffix + ".csv");
            generateDataWithNRIC(testCsvFilePath);
        }
    }

    @Test
    public void newTest()
    {
      //  StorageAccountConfig spyStorageAccountConfig = spy(storageAccountConfig);
        DemoRunner demoApplication = new DemoRunner(car, persistenceRepository);
        verify(storageAccountConfig,times(2)).getConnectionString();
        System.out.println("Inside Demo Runner Test:" + storageAccountConfig.getConnectionString());

    }

    private File generateDataWithNRIC(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            StringBuilder header = new StringBuilder("nric");
            for (int i = 1; i <= 5; i++) {
                header.append(",int_column_" + i);
            }
            for (int i = 1; i <= 5; i++) {
                header.append(",double_column_" + i);
            }
            for (int i = 1; i <= 5; i++) {
                header.append(",float_column_" + i);
            }
            for (int i = 1; i <= 5; i++) {
                header.append(",date_column_" + i);
            }
            for (int i = 1; i <= 10; i++) {
                header.append(",string_column_" + i);
            }
            writer.write(header.toString());
            for (int lineIndex = 1; lineIndex <= EXTREME_LOAD; lineIndex++) {
                StringBuilder record = new StringBuilder(TestFileSetupHelper.getRandomNRIC());
                for (int i = 1; i <= 5; i++) {
                    record.append(",").append(RANDOM.nextInt(LIMIT));
                }
                for (int i = 1; i <= 5; i++) {
                    record.append(",").append(String.format("%.4f", RANDOM.nextDouble() * LIMIT));
                }
                for (int i = 1; i <= 5; i++) {
                    record.append(",").append(String.format("%.4f", RANDOM.nextDouble() * LIMIT));
                }
                for (int i = 1; i <= 5; i++) {
                    record.append(",").append(getRandomDate());
                }
                for (int i = 1; i <= 10; i++) {
                    record.append(",").append(RandomStringUtils.randomAlphabetic(40));
                }
                writer.write(System.lineSeparator() + record);
                if (lineIndex % 400000 == 0) {
                    log.info("Generated random records: {}...", lineIndex);
                }
            }
        }
        return new File(filePath);
    }

    public static String getRandomDate() {
        int day = RANDOM.nextInt(31) + 1;
        int month = RANDOM.nextInt(12) + 1;
        int year = RANDOM.nextInt(31) + 1990;
        if (month == 2 && day > 28) {
            day = 28;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            day = 30;
        }
        return year + "/" + (month < 10 ? "0" : "") + month + "/" + (day < 10 ? "0" : "") + day;
    }

}

