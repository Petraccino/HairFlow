package it.hair.flow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import it.hair.flow.config.details.CredentialDetailsService;
import it.hair.flow.costant.Constant;


@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
			new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.REGISTER_GENERIC),
			new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.LOGIN_GENERIC),
			new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.GENERATE_TOKEN),
			new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.VALIDATE_TOKEN),
            new AntPathRequestMatcher(Constant.DOUBLE_STAR + Constant.SWAGGER_UI_PATH),
            new AntPathRequestMatcher(Constant.SWAGGER_UI + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.SWAGGER_UI + Constant.SLASH_STAR),
            new AntPathRequestMatcher(Constant.SWAGGER_UI_PATH),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.SWAGGER_UI_PATH + Constant.SLASH_STAR),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.SWAGGER_UI + Constant.INDEX_HTML + Constant.ONE_STAR),
            new AntPathRequestMatcher(Constant.SWAGGER_UI + Constant.INDEX_HTML + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.V3_API_DOCS + Constant.SLASH_DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.V3_API_DOCS + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.V3_API_DOCS + Constant.YAML),
            new AntPathRequestMatcher(Constant.V3_OPENAPI_YAML),
            new AntPathRequestMatcher(Constant.SWAGGER_UI_RESOURCES),
            new AntPathRequestMatcher(Constant.ACTUATOR_PATH),
            new AntPathRequestMatcher(Constant.CONFIG_JSON_PATH),
            new AntPathRequestMatcher(Constant.DOUBLE_STAR + Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI_PATH),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI + Constant.SLASH_STAR),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI_PATH),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI_PATH + Constant.SLASH_STAR),
            new AntPathRequestMatcher(Constant.ONE_STAR + Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI + Constant.INDEX_HTML + Constant.ONE_STAR),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI + Constant.INDEX_HTML + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.V3_API_DOCS + Constant.SLASH_DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.V3_API_DOCS + Constant.DOUBLE_STAR),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.V3_API_DOCS + Constant.YAML),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.V3_OPENAPI_YAML),
            new AntPathRequestMatcher(Constant.REQUEST_MAPPING_AUTH + Constant.SWAGGER_UI_RESOURCES)
            
    );
	
	@Bean
	UserDetailsService userDetailsService(){
        return new CredentialDetailsService();
    }
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(PUBLIC_URLS).permitAll()
                .and()
                .build();
    }
	
	@Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
