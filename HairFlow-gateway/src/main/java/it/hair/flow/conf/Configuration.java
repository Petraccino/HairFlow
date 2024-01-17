package it.hair.flow.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
    @Bean
    RestTemplate template(){
       return new RestTemplate();
    }
	
}
