package it.hair.flow.repository;

import java.util.Optional;

import it.hair.flow.entity.Utente;

public interface UtenteRepository extends CredentialRepository<Utente, Integer> {
	Optional<Utente> findByEmail(String email);
}
