package it.hair.flow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.AdminRepository;
import it.hair.flow.repository.ClienteRepository;
import it.hair.flow.repository.UtenteRepository;
import it.hair.flow.service.AuthService;
import it.hair.flow.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
    private AdminRepository adminRepository;
	@Autowired
    private UtenteRepository utenteRepository;
	@Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
	
	@Override
	public Utente registerUser(Utente utente) {
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		return utenteRepository.save(utente);
	}

	@Override
	public Utente loginUser(String email, String password) {
		 String encodedPassword = passwordEncoder.encode(password);
		return utenteRepository.findByEmailAndPassword(email, encodedPassword).orElseThrow(()-> new BadCredentialsException("User not found"));
	}

	@Override
	public Cliente registerClient(Cliente cliente) {
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente loginClient(String email, String password) {
		return clienteRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new BadCredentialsException("Client not found"));
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new BadCredentialsException("Admin not found"));
	}

	@Override
	public String generateToken(String email) {
		return jwtService.generateToken(email);
	}

	@Override
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
