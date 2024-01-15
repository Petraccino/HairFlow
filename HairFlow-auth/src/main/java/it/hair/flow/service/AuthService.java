package it.hair.flow.service;

import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;

public interface AuthService {
	
	Utente registerUser(Utente utente);
	Utente loginUser(String email, String password);
	Cliente registerClient(Cliente cliente);
	Cliente loginClient(String email, String password);
	Admin loginAdmin(String email, String password);
	String generateToken(String email);
    void validateToken(String token);
}