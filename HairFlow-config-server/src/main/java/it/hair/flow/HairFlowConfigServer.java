package it.hair.flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HairFlowConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(HairFlowConfigServer.class, args);
    }
}