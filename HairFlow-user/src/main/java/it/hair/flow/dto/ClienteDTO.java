package it.hair.flow.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private Integer id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    @JsonIgnore
    private String password;
    private String provincia;
    private String email;
    private String numeroTelefono;
    private String sesso;
    private LocalDate dataUltimaVisita;
    private OffsetDateTime dataRegistrazione;
    private Integer grant;
	
}
