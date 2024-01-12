package it.hair.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hair.flow.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
