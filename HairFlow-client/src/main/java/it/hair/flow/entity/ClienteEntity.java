package it.hair.flow.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable{

	private static final long serialVersionUID = -4953162641040313047L;
	
	@Id
    @Column(name = "id_cliente", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "cognome", length = 30)
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "provincia", length = 50)
    private String provincia;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "numero_telefono", length = 15)
    private String numeroTelefono;

    @Column(name = "sesso", nullable = false, length = 1)
    private String sesso;

    @Column(name = "data_ultima_visita")
    private LocalDate dataUltimaVisita;

    @Column(name = "data_registrazione", nullable = false)
    private Timestamp dataRegistrazione;
}
