package it.hair.flow.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "utente_cliente")
@Data
public class UtenteCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "utente_id", nullable = false)
    private Integer utenteId;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

}
