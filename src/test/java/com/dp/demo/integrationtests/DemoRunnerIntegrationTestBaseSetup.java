package com.dp.demo.integrationtests;

import com.dp.demo.configuration.ContextMockConfiguration;
import com.dp.demo.dependencyconfiguration.PersistenceConfig;
import com.dp.demo.dependencyconfiguration.ServiceConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;



@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {ServiceConfig.class,
                                    PersistenceConfig.class,
                                    ContextMockConfiguration.class},
                                    loader = AnnotationConfigContextLoader.class)
public class DemoRunnerIntegrationTestBaseSetup {
}
