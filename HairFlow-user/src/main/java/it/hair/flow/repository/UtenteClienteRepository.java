package it.hair.flow.repository;

import it.hair.flow.entity.UtenteCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteClienteRepository extends JpaRepository<UtenteCliente, Integer> {

    void deleteByClienteId(Integer clienteId);

}
