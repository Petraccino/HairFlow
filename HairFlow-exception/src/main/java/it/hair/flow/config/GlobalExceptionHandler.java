package it.hair.flow.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }
	
//	@ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleUsernameNotFoundException(RuntimeException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
//    }
}
