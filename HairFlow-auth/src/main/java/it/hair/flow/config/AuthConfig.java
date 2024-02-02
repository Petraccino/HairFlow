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


@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	private static final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
			new AntPathRequestMatcher("/auth/register/**"),
			new AntPathRequestMatcher("/auth/login/**"),
			new AntPathRequestMatcher("/auth/generate/token"),
			new AntPathRequestMatcher("/auth/validate/token"),
            new AntPathRequestMatcher("**/swagger-ui.html"),
            new AntPathRequestMatcher("/swagger-ui**"),
            new AntPathRequestMatcher("*/swagger-ui/*"),
            new AntPathRequestMatcher("/swagger-ui.html"),
            new AntPathRequestMatcher("*/swagger-ui.html/*"),
            new AntPathRequestMatcher("*/swagger-ui/index.html/*"),
            new AntPathRequestMatcher("/swagger-ui/index.html/**"),
            new AntPathRequestMatcher("/v3/api-docs/**"),
            new AntPathRequestMatcher("/v3/api-docs**"),
            new AntPathRequestMatcher("/v3/api-docs.yaml"),
            new AntPathRequestMatcher("/v3/openapi.yaml"),
            new AntPathRequestMatcher("/swagger-ui/**"),
            new AntPathRequestMatcher("/actuator/**"),
            new AntPathRequestMatcher("/config.json")
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
