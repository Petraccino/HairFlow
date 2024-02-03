package it.hair.flow.service;

import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;

public interface AuthService {
	
	UtenteDTO registerUser(UtenteDTO utente);
	UtenteDTO loginUser(String email, String password);
	ClienteDTO registerClient(ClienteDTO cliente);
	ClienteDTO loginClient(String email, String password);
	AdminDTO loginAdmin(String email, String password);
	String generateToken(String email);
    void validateToken(String token);
}