package it.hair.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HairFlowHealtCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairFlowHealtCheckApplication.class, args);
	}

}
