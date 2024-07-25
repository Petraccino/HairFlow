package it.hair.flow.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Credential implements Serializable{

	private static final long serialVersionUID = -4953162641040313047L;
	
	@Id
    @Column(nullable = false, updatable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(length = 20, name = "provincia")
    private String provincia;

//    @Column(nullable = false, unique = true, length = 55, name = "email")
//    private String email;

    @Column(length = 20, name = "numero_telefono")
    private String numeroTelefono;

    @Column(length = 1, name = "sesso")
    private String sesso;

    @Column(name = "data_ultima_visita")
    private LocalDate dataUltimaVisita;

    @Column(name = "data_registrazione")
    private OffsetDateTime dataRegistrazione;

//    @Column(nullable = false, length = 150, name = "password")
//    private String password;

    @ManyToOne
    @JoinColumn(name = "grant_id")
    private Grant grant;

}
