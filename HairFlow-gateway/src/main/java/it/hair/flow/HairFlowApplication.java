package it.hair.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HairFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairFlowApplication.class, args);
	}

}
