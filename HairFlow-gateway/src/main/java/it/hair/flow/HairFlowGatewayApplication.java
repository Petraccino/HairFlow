package it.hair.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HairFlowGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairFlowGatewayApplication.class, args);
	}

}
