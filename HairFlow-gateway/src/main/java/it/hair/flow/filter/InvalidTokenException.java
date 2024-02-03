package it.hair.flow.filter;

public class InvalidTokenException extends RuntimeException {
	private static final long serialVersionUID = 6632845169153195396L;
	private String token;
	private String uri;
	
	public InvalidTokenException(String message, String token, String uri) {
        super(message);
        this.token= token;
        this.uri = uri;
    }
	
	public InvalidTokenException(String message, String uri) {
        super(message); 
        this.uri = uri;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
