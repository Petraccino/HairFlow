package it.hair.flow.swagger;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class SpringFoxConfig {
	@Bean
	 RouteLocator routeLocator(RouteLocatorBuilder builder) {
	  return builder
	    .routes()
	    .route(r -> r.path("/client/v3/api-docs").and().method(HttpMethod.GET).uri("lb://HAIRFLOW-CLIENT"))
	    .route(r -> r.path("/user/v3/api-docs").and().method(HttpMethod.GET).uri("lb://HAIRFLOW-USER"))
	    .route(r -> r.path("/user/v3/api-docs").and().method(HttpMethod.GET).uri("lb://HAIRFLOW-AUTH"))
	    .build();
	 }
}
