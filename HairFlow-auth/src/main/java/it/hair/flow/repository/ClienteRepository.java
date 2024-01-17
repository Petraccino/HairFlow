package it.hair.flow.repository;

import java.util.Optional;

import it.hair.flow.entity.Cliente;

public interface ClienteRepository extends CredentialRepository<Cliente, Integer>{
	Optional<Cliente> findByEmail(String email);

}
