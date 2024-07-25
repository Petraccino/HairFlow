package it.hair.flow.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -2229427239748020099L;
    private Integer id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String provincia;
    private String email;
    private String numeroTelefono;
    private String sesso;
    private LocalDate dataUltimaVisita;
    private OffsetDateTime dataRegistrazione;
    private String password;
    private GrantDTO grant;
}
