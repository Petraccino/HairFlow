package it.hair.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hair.flow.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
