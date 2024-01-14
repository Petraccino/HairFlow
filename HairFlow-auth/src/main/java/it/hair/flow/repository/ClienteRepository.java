package it.hair.flow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hair.flow.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Optional<Cliente> findByEmailAndPassword(String email, String password);
}
