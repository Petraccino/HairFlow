package it.hair.flow.swagger;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import it.hair.flow.constant.Constant;

@Configuration
public class SpringFoxConfig {
	
	@Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(Constant.GATEWAY_TITLE_API)
                        .description(Constant.GATEWAY_DESCRIPTION_API)
                        .version(Constant.GATEWAY_VERSION_API)
                        .contact(contact())
                        .contact(additionalContact())
                        .license(new License().name(Constant.APACHE_VERSION).url(Constant.APACHE_URL)));
    }

	private Contact contact() {
		return new Contact().name(Constant.DANIELE_PETRACCINI).email(Constant.DANIELE_PETRACCINI_EMAIL).url(Constant.DANIELE_PETRACCINI_LINKEDIN);
	}
	
	private Contact additionalContact() {
		return new Contact().name(Constant.MARCO_PETRACCINI).email(Constant.MARCO_PETRACCINI_EMAIL).url(Constant.MARCO_PETRACCINI_LINKEDIN);
    }
	
	@Bean
	 RouteLocator routeLocator(RouteLocatorBuilder builder) {
	  return builder
	    .routes()
	    .route(r -> r.path(Constant.CLIENT_API_DOCS).and().method(HttpMethod.GET).uri(Constant.CLIENT_STATIC_ENDPOINT))
	    .route(r -> r.path(Constant.USER_API_DOCS).and().method(HttpMethod.GET).uri(Constant.USER_STATIC_ENDPOINT))
	    .route(r -> r.path(Constant.AUTH_API_DOCS).and().method(HttpMethod.GET).uri(Constant.AUTH_STATIC_ENDPOINT))
	    .build();
	 }
}
