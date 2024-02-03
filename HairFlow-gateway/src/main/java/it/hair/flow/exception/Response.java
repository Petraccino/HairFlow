package it.hair.flow.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	private String message;
	private String uri;
	private String token;
}
