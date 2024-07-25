package it.hair.flow.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.hair.flow.client.AdminClient;
import it.hair.flow.client.ClientClient;
import it.hair.flow.client.UserClient;
import it.hair.flow.entity.Grant;
import lombok.RequiredArgsConstructor;
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

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	
    private final CredentialRepository<Admin, Integer> credentialAdminRepository;
	
    private final CredentialRepository<Utente, Integer> credentialUtenteRepository;
	
    private final CredentialRepository<Cliente, Integer> credentialClienteRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtService jwtService;

	private final AdminClient adminClient;

	private final UserClient userClient;

	private final ClientClient clientClient;

	private final ObjectMapper objectMapper;
	
	public UtenteDTO registerUser(UtenteDTO utente) {
		utente.setPassword(passwordEncoder.encode(utente.getPassword()));
		Utente userToRegister = objectMapper.convertValue(utente, Utente.class);
		userToRegister.setGrant(Grant.builder().id(2).build());
		userToRegister.setDataRegistrazione(OffsetDateTime.now());
        Utente registeredUser = credentialUtenteRepository.save(userToRegister);
        return userClient.findById(registeredUser.getId());
	}

	
	public UtenteDTO loginUser(String email, String password) {
		 Utente utente = credentialUtenteRepository.findUtenteByEmail(email)
				 .filter(u -> passwordEncoder.matches(password, u.getPassword()))
				 .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
		 return userClient.findById(utente.getId());
	}

	
	public ClienteDTO registerClient(ClienteDTO cliente) {
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
		Cliente clientToRegister = objectMapper.convertValue(cliente, Cliente.class);
		clientToRegister.setGrant(Grant.builder().id(3).build());
		clientToRegister.setDataRegistrazione(OffsetDateTime.now());
        Cliente registeredClient = credentialClienteRepository.save(clientToRegister);
        return clientClient.findById(registeredClient.getId());
	}
	
	public ClienteDTO loginClient(String email, String password) {
		Cliente cliente = credentialClienteRepository.findClienteByEmail(email)
                .filter(c -> passwordEncoder.matches(password, c.getPassword()))
                .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
        return clientClient.findById(cliente.getId());
	}

	
	public AdminDTO loginAdmin(String email, String password) {
		Admin admin = credentialAdminRepository.findAdminByEmail(email)
                .filter(a -> passwordEncoder.matches(password, a.getPassword()))
                .orElseThrow(() -> new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + email));
        return adminClient.findById(admin.getId());
	}

	
	public String generateToken(String email) {
		return jwtService.generateToken(email);
	}

	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
