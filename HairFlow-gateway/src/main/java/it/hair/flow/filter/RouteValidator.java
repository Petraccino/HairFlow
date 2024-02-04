package it.hair.flow.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import it.hair.flow.constant.Constant;

@Component
public class RouteValidator {

 	public static final List<String> openApiEndpoints = List.of(
            Constant.AUTH_BASE_PATH + Constant.REGISTER_USER,
            Constant.AUTH_BASE_PATH + Constant.LOGIN_USER,
            Constant.AUTH_BASE_PATH + Constant.LOGIN_CLIENT,
            Constant.AUTH_BASE_PATH + Constant.REGISTER_CLIENT,
            Constant.AUTH_BASE_PATH + Constant.LOGIN_ADMIN,
            Constant.AUTH_BASE_PATH + Constant.GENERATE_TOKEN,
            Constant.EUREKA_PATH
	    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
	
}
