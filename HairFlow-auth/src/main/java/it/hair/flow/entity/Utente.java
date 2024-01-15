package it.hair.flow.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	
	@Column(name = "grant_id", nullable = false)
    private Integer grant;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "informazioni_id", unique = true)
    private InformazioniAdminUtente informazioni;
}
