package it.hair.flow.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.Data;

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
