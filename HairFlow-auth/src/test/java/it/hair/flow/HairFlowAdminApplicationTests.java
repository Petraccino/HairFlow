package it.hair.flow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class HairFlowAdminApplicationTests {

	@Container
	static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0")
			.withDatabaseName("test")
			.withUsername("test")
			.withPassword("test")
			.withFileSystemBind("src/main/resources/application-test.yaml", "/usr/share/nginx/html/application-test.yaml", BindMode.READ_ONLY);

	@Container
	static GenericContainer<?> configServerContainer = new GenericContainer<>("nginx:latest")
			.withExposedPorts(80)
			.withFileSystemBind("src/main/resources/application-test.yaml", "/usr/share/nginx/html/application-test.yaml", BindMode.READ_ONLY);


	@DynamicPropertySource
	static void mySQLContainerProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", mySQLContainer::getUsername);
		registry.add("spring.datasource.password", mySQLContainer::getPassword);

		String configServerUrl = "http://" + configServerContainer.getHost() + ":" + configServerContainer.getMappedPort(80);
		registry.add("spring.cloud.config.uri", () -> configServerUrl);

		registry.add("eureka.client.registerWithEureka", () -> false);
		registry.add("eureka.client.fetchRegistry", () -> false);

	}


	@Test
	void contextLoads() {
	}

}
