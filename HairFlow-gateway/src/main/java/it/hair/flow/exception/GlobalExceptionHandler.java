package it.hair.flow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.hair.flow.filter.InvalidTokenException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidTokenException.class)
	ResponseEntity<Response> handleInvalidTokenException(InvalidTokenException ex) {
		Response rs = new Response(ex.getMessage(), ex.getUri(), ex.getToken());
		return new ResponseEntity<Response>(rs, HttpStatus.UNAUTHORIZED);
	}

}
