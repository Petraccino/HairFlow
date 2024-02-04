package it.hair.flow.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import it.hair.flow.constant.Constant;
import it.hair.flow.filter.InvalidTokenException;
import it.hair.flow.filter.RouteValidator;
import it.hair.flow.util.JwtUtil;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{
	
	@Autowired
	private RouteValidator validator;
	@Autowired
    private JwtUtil jwtUtil;
	
	public static class Config {}
	public AuthenticationFilter() {
        super(Config.class);
    }
	
	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new InvalidTokenException(Constant.INVALID_TOKEN_EXCEPTION_MISSING_HEADER, exchange.getRequest().getURI().getPath());
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith(Constant.BEARER)) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    jwtUtil.validateToken(authHeader);
                } catch (Exception e) {
                	throw new InvalidTokenException(Constant.INVALID_TOKEN_EXCEPTION_UNAUTHORIZED_HEADER, authHeader, exchange.getRequest().getURI().getPath());
                }
            }
            return chain.filter(exchange);
        });
	}

}
