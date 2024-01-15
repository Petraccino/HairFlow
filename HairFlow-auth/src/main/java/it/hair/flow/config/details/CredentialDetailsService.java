package it.hair.flow.config.details;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.CredentialRepository;

public class CredentialDetailsService implements UserDetailsService {
	
	@Autowired
    private CredentialRepository<Admin, Integer> adminRepository;

    @Autowired
    private CredentialRepository<Utente, Integer> utenteRepository;

    @Autowired
    private CredentialRepository<Cliente, Integer> clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Admin> admin = adminRepository.findAdminByEmail(email);
        Optional<Utente> utente = utenteRepository.findUtenteByEmail(email);
        Optional<Cliente> cliente = clienteRepository.findClienteByEmail(email);
        if (admin.isPresent()) {
            return new CredentialDetails(admin.get());
        } else if (utente.isPresent()) {
            return new CredentialDetails(utente.get());
        } else if (cliente.isPresent()) {
            return new CredentialDetails(cliente.get());
        } else {
            throw new UsernameNotFoundException("User not found with email:" + email);
        }
	}

}
