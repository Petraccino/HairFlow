package it.hair.flow.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "informazioni_admin_utente")
@Data
public class InformazioniAdminUtente {
	
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

    @Column(length = 20, name = "numero_telefono")
    private String numeroTelefono;

    @Column(length = 1, name = "sesso")
    private String sesso;

    @Column(length = 30, name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "data_registrazione")
    private OffsetDateTime dataRegistrazione;
	
}
