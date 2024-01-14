package it.hair.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hair.flow.entity.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
