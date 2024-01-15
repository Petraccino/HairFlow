package it.hair.flow.service;

public interface JwtService {
    void validateToken(final String token);
    String generateToken(String email);
    
}
