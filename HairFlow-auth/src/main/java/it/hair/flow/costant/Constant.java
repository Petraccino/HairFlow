package it.hair.flow.costant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	public final static String ADMIN = "admin";
	public final static String USER = "user";
	public final static String CLIENT = "client";
	public final static Integer ADMIN_GRANT = 1;
	public final static Integer USER_GRANT = 2;
	public final static Integer CLIENT_GRANT = 3;
	
	public final static String REQUEST_MAPPING_AUTH = "/auth";
	public final static String REGISTER_USER = "/register/user";
	public final static String LOGIN_USER = "/login/user";
	public final static String REGISTER_CLIENT = "/register/client";
	public final static String LOGIN_CLIENT = "/login/client";
	public final static String LOGIN_ADMIN = "/login/admin";
	public final static String GENERATE_TOKEN = "/generate/token";
	public final static String VALIDATE_TOKEN = "/validate/token";
	
	public static final Map<String, Integer> URI_GRANT_MAP = new HashMap<>();
    static {
        URI_GRANT_MAP.put(Constant.ADMIN, Constant.ADMIN_GRANT);
        URI_GRANT_MAP.put(Constant.USER, Constant.USER_GRANT);
        URI_GRANT_MAP.put(Constant.CLIENT, Constant.USER_GRANT);
    }
    
	public final static String BAD_CREDENTIALS_EXCEPTION = "Credenziali d'accesso non valide per ";
	public final static String ADMIN_USURNAME_NOT_FOUND_EXCEPTION = "Admin non trovato con la seguente email: ";
	public final static String USER_USURNAME_NOT_FOUND_EXCEPTION = "Utente non trovato con la seguente email: ";
	public final static String CLIENT_USURNAME_NOT_FOUND_EXCEPTION = "Cliente non trovato con la seguente email: ";
	public final static String GENERIC_USURNAME_NOT_FOUND_EXCEPTION = "Nessuna tipologia di utilizzatore trovato con la seguente email: ";



	public final static String AUTH_TITLE_GROUP_API = "HAIRFLOW-AUTH";
	public final static String NAMING_PACKAGE_CONTROLLER = "it.hair.flow.controller";
	public final static String AUTH_TITLE_API = "Hair Flow Auth API";
	public final static String AUTH_DESCRIPTION_API = "Gestione autenticazione di Hair Flow";
	public final static String AUTH_VERSION_API = "1.0";
	public final static String APACHE_VERSION = "Apache 2.0";
	public final static String APACHE_URL = "http://springdoc.org";
	public final static String MARCO_PETRACCINI = "Marco Petraccini";
	public final static String DANIELE_PETRACCINI = "Daniele Petraccini";
	public final static String MARCO_PETRACCINI_EMAIL = "m.petraccini@hotmail.com";
	public final static String DANIELE_PETRACCINI_EMAIL = "daniele.petrach@gmail.com";
	public final static String MARCO_PETRACCINI_LINKEDIN = "https://www.linkedin.com/in/marcopetraccini/";
	public final static String DANIELE_PETRACCINI_LINKEDIN = "https://www.linkedin.com/in/daniele-petraccini/";
	
	public static final String SWAGGER_UI = "/swagger-ui";
	public static final String SWAGGER_UI_PATH = "/swagger-ui.html";
	public static final String SWAGGER_UI_RESOURCES = "/swagger-ui/**";
	public static final String V3_API_DOCS = "/v3/api-docs";
	public static final String OPENAPI_YAML = "/openapi.yaml";
	public static final String INDEX_HTML = "/index.html/";
	public static final String YAML = ".yaml";
	public static final String V3_OPENAPI_YAML = "/v3/openapi.yaml";
	public static final String REGISTER_GENERIC = "/register/**";
	public static final String LOGIN_GENERIC = "/login/**";
	public static final String CONFIG_JSON_PATH = "/config.json";
	public static final String ACTUATOR_PATH = "/actuator/**";
	public static final String DOUBLE_STAR = "**";
	public static final String ONE_STAR = "*";
	public static final String SLASH_STAR = "/*";
	public static final String SLASH_DOUBLE_STAR = "/**";




	

}
