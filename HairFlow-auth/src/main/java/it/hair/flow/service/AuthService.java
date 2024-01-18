package it.hair.flow.service;

import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;

public interface AuthService {
	
	UtenteDTO registerUser(Utente utente);
	UtenteDTO loginUser(String email, String password);
	ClienteDTO registerClient(Cliente cliente);
	ClienteDTO loginClient(String email, String password);
	AdminDTO loginAdmin(String email, String password);
	String generateToken(String email);
    void validateToken(String token);
}