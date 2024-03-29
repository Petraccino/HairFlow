package it.hair.flow.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

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

    @Column(nullable = false, unique = true, length = 55, name = "email")
    private String email;

    @Column(length = 20, name = "numero_telefono")
    private String numeroTelefono;

    @Column(length = 1, name = "sesso")
    private String sesso;

    @Column(name = "data_ultima_visita")
    private LocalDate dataUltimaVisita;

    @Column(name = "data_registrazione")
    private OffsetDateTime dataRegistrazione;

    @Transient
    @Column(nullable = false, length = 150, name = "password")
    private String password;
 
//    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "grant_id", unique = true)
//    private Grant grant;
  
  @Column(name = "grant_id", nullable = false)
  private Integer grant;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utente_cliente",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id")
    )
    @JsonManagedReference
    private List<Utente> utentes = new ArrayList<>();
}
