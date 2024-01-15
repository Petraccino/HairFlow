package it.hair.flow.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Credential;
import it.hair.flow.entity.Utente;

@NoRepositoryBean
public interface CredentialRepository<T extends Credential, ID extends Serializable> extends JpaRepository<T, ID>{
	Optional<Admin> findAdminByEmail(String email);
    Optional<Utente> findUtenteByEmail(String email);
    Optional<Cliente> findClienteByEmail(String email);
}
