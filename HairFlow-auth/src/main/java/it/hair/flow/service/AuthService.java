package it.hair.flow.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.CredentialRepository;
import it.hair.flow.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	
    private final CredentialRepository<Admin, Integer> credentialAdminRepository;
	
    private final CredentialRepository<Utente, Integer> credentialUtenteRepository;
	
    private final CredentialRepository<Cliente, Integer> credentialClienteRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtService jwtService;
    
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;
    
    @Qualifier("modelMapperSkypPasswordCliente")
    private ModelMapper modelMapperSkypPasswordCliente;
    
    @Qualifier("modelMapperSkypPasswordUtente")
    private ModelMapper modelMapperSkypPasswordUtente;
	
	
	public UtenteDTO registerUser(UtenteDTO utente) {
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		Utente register = modelMapper.map(utente, Utente.class);
        UtenteDTO utenteDTO = modelMapperSkypPasswordUtente.map(credentialUtenteRepository.save(register), UtenteDTO.class);
        return utenteDTO;
	}

	
	public UtenteDTO loginUser(String email, String password) {
		 Utente utente = credentialUtenteRepository.findUtenteByEmail(email)
				 .filter(u -> passwordEncoder.matches(password, u.getPassword()))
				 .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
		 return modelMapperSkypPasswordUtente.map(utente, UtenteDTO.class); 
	}

	
	public ClienteDTO registerClient(ClienteDTO cliente) {
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
		Cliente register = modelMapper.map(cliente, Cliente.class);
        ClienteDTO clienteDTO = modelMapperSkypPasswordCliente.map(credentialClienteRepository.save(register), ClienteDTO.class);
        return clienteDTO;
	}

	
	public ClienteDTO loginClient(String email, String password) {
		Cliente cliente = credentialClienteRepository.findClienteByEmail(email)
                .filter(c -> passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
        return modelMapperSkypPasswordCliente.map(cliente, ClienteDTO.class);
	}

	
	public AdminDTO loginAdmin(String email, String password) {
		Admin admin = credentialAdminRepository.findAdminByEmail(email)
                .filter(a -> passwordEncoder.matches(password, a.getPassword()))
                .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
        return modelMapper.map(admin, AdminDTO.class);
	}

	
	public String generateToken(String email) {
		return jwtService.generateToken(email);
	}

	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
