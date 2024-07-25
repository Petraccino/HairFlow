package it.hair.flow.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "utente")
@Data
@EqualsAndHashCode(callSuper = true)
public class Utente extends Credential implements Serializable{

	private static final long serialVersionUID = 1202123354994470684L;

	@Id
    @Column(nullable = false, updatable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(nullable = false, unique = true, length = 55, name = "email")
//    private String email;
//
//    @Column(nullable = false, length = 150, name = "password")
//    private String password;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(length = 20, name = "provincia")
    private String provincia;

    @Column(length = 20, name = "numero_telefono")
    private String numeroTelefono;

    @Column(length = 1, name = "sesso")
    private String sesso;

    @Column(length = 30, name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "data_registrazione")
    private OffsetDateTime dataRegistrazione;

    @ManyToOne
    @JoinColumn(name = "grant_id")
    private Grant grant;
}
