package it.hair.flow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class HairFlowGatewayApplicationTests {

	@DynamicPropertySource
	static void mySQLContainerProperties(DynamicPropertyRegistry registry) {
		registry.add("eureka.client.registerWithEureka", () -> false);
		registry.add("eureka.client.fetchRegistry", () -> false);
	}

	@Test
	void contextLoads() {
	}

}
