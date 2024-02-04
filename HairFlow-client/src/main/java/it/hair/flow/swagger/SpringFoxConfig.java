package it.hair.flow.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import it.hair.flow.costant.Constant;

@Configuration
public class SpringFoxConfig {
	@Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(Constant.CLIENT_TITLE_GROUP_API)
                .packagesToScan(Constant.NAMING_PACKAGE_CONTROLLER)
                .build();
    }

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(Constant.CLIENT_TITLE_API)
                        .description(Constant.CLIENT_DESCRIPTION_API)
                        .version(Constant.CLIENT_VERSION_API)
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
}
