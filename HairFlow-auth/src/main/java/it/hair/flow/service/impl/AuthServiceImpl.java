package it.hair.flow.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.CredentialRepository;
import it.hair.flow.service.AuthService;
import it.hair.flow.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
    private CredentialRepository<Admin, Integer> credentialAdminRepository;
	@Autowired
    private CredentialRepository<Utente, Integer> credentialUtenteRepository;
	@Autowired
    private CredentialRepository<Cliente, Integer> credentialClienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private ModelMapper modelMapper;
	
	@Override
	public UtenteDTO registerUser(UtenteDTO utente) {
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		Utente register = modelMapper.map(utente, Utente.class);
        UtenteDTO utenteDTO = modelMapper.map(credentialUtenteRepository.save(register), UtenteDTO.class);
        return utenteDTO;
	}

	@Override
	public UtenteDTO loginUser(String email, String password) {
		 Utente utente = credentialUtenteRepository.findUtenteByEmail(email)
				 .filter(u -> passwordEncoder.matches(password, u.getPassword()))
				 .orElseThrow(() -> new BadCredentialsException("User not found"));
		 return modelMapper.map(utente, UtenteDTO.class); 
	}

	@Override
	public ClienteDTO registerClient(ClienteDTO cliente) {
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
		Cliente register = modelMapper.map(cliente, Cliente.class);
        ClienteDTO clienteDTO = modelMapper.map(credentialClienteRepository.save(register), ClienteDTO.class);
        return clienteDTO;
	}

	@Override
	public ClienteDTO loginClient(String email, String password) {
		Cliente cliente = credentialClienteRepository.findClienteByEmail(email)
                .filter(c -> passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Client not found"));
        return modelMapper.map(cliente, ClienteDTO.class);
	}

	@Override
	public AdminDTO loginAdmin(String email, String password) {
		Admin admin = credentialAdminRepository.findAdminByEmail(email)
                .filter(a -> passwordEncoder.matches(password, a.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Admin not found"));
        return modelMapper.map(admin, AdminDTO.class);
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
