package it.hair.flow.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringFoxConfig {
	@Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("HAIRFLOW-USER")
                .packagesToScan("it.hair.flow.controller")
                .build();
    }

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Hair Flow User API")
                        .description("Gestione per utenti di Hair Flow")
                        .version("1.0")
                        .contact(contact())
                        .contact(additionalContact())
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

	private Contact contact() {
		return new Contact().name("Marco Petraccini").email("m.petraccini@hotmail.com").url("https://www.linkedin.com/in/marcopetraccini//");
	}
	
	private Contact additionalContact() {
		return new Contact().name("Daniele Petraccini").email("daniele.petrach@gmail.com").url("https://www.linkedin.com/in/daniele-petraccini/");
    }
}
