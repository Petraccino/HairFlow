package it.hair.flow.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.hair.flow.costant.Constant;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    private ResponseEntity<Response> handleException(Exception ex, HttpServletRequest request, Predicate<String> uriFilter, HttpStatus status) {
        Response rs = new Response(ex.getMessage(), request.getRequestURI());
        Constant.URI_GRANT_MAP.entrySet().stream()
            .filter(entry -> uriFilter.test(entry.getKey()))
            .findFirst()
            .ifPresent(entry -> rs.setGrant(entry.getValue()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    ResponseEntity<Response> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, HttpServletRequest request) {
        return handleException(ex, request, uri -> request.getRequestURI().contains(uri), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<Response> handleBadCredentialsException(BadCredentialsException ex, HttpServletRequest request) {
        return handleException(ex, request, uri -> request.getRequestURI().contains(uri), HttpStatus.BAD_REQUEST);
    }
}
