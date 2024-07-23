package it.hair.flow.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class InformazioniAdminUtenteDTO {
	
	private Integer id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String provincia;
    private String numeroTelefono;
    private String sesso;
    private String codiceFiscale;
    private OffsetDateTime dataRegistrazione;
	
}
