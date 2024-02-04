package it.hair.flow.constant;

public class Constant {
	
	public final static String INVALID_TOKEN_EXCEPTION_MISSING_HEADER = "Missing authorization header";
	public final static String INVALID_TOKEN_EXCEPTION_UNAUTHORIZED_HEADER = "Unauthorized access to application";
	public final static String BEARER = "Bearer ";
	public final static String AUTH_BASE_PATH = "/auth";
	public final static String REGISTER_USER = "/register/user";
	public final static String LOGIN_USER = "/login/user";
	public final static String REGISTER_CLIENT = "/register/client";
	public final static String LOGIN_CLIENT = "/login/client";
	public final static String LOGIN_ADMIN = "/login/admin";
	public final static String GENERATE_TOKEN = "/generate/token";
	public final static String EUREKA_PATH = "/eureka";
	
	public final static String GATEWAY_TITLE_GROUP_API = "HAIRFLOW-GATEWAY";
	public final static String GATEWAY_TITLE_API = "Hair Flow Gateway API";
	public final static String GATEWAY_DESCRIPTION_API = "Gestione del gateway di Hair Flow";
	public final static String GATEWAY_VERSION_API = "1.0";
	public final static String APACHE_VERSION = "Apache 2.0";
	public final static String APACHE_URL = "http://springdoc.org";
	public final static String MARCO_PETRACCINI = "Marco Petraccini";
	public final static String DANIELE_PETRACCINI = "Daniele Petraccini";
	public final static String MARCO_PETRACCINI_EMAIL = "m.petraccini@hotmail.com";
	public final static String DANIELE_PETRACCINI_EMAIL = "daniele.petrach@gmail.com";
	public final static String MARCO_PETRACCINI_LINKEDIN = "https://www.linkedin.com/in/marcopetraccini/";
	public final static String DANIELE_PETRACCINI_LINKEDIN = "https://www.linkedin.com/in/daniele-petraccini/";
	public final static String CLIENT_API_DOCS = "/client/v3/api-docs";
	public final static String AUTH_API_DOCS = "/auth/v3/api-docs";
	public final static String USER_API_DOCS = "/user/v3/api-docs";
	public final static String CLIENT_STATIC_ENDPOINT = "lb://HAIRFLOW-CLIENT";
	public final static String USER_STATIC_ENDPOINT = "lb://HAIRFLOW-USER";
	public final static String AUTH_STATIC_ENDPOINT = "lb://HAIRFLOW-AUTH";


	
}
