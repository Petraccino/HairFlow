package it.hair.flow.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "utente")
@Data
public class Utente {
	
	@Id
    @Column(nullable = false, updatable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 55, name = "email")
    private String email;

    @Column(nullable = false, length = 150, name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "grant_id")
    private Grant grant;

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

    @OneToMany
    @JoinColumn(name = "utente_id", referencedColumnName = "id")
    private List<UtenteCliente> utentiAssociati;
	
}
