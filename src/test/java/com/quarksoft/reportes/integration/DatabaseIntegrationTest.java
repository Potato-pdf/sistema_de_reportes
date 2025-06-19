package com.quarksoft.reportes.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class DatabaseIntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("reportes_db_test")
            .withUsername("reportes_user")
            .withPassword("reportes_pass");

    @Test
    void testContainerIsRunning() {
        assertTrue(postgres.isRunning());
    }
}
