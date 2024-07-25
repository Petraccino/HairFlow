package it.hair.flow.dto;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class AdminDTO {

    private Integer id;
    private String email;
    private String password;
    private GrantDTO grant;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String provincia;
    private String numeroTelefono;
    private String sesso;
    private String codiceFiscale;
    private OffsetDateTime dataRegistrazione;

}
