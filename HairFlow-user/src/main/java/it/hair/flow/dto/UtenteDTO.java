package it.hair.flow.dto;

import java.util.List;

import lombok.Data;

@Data
public class UtenteDTO {
	
	private Integer id;
    private String email;
    private String password;
    private Integer grant;
    private InformazioniAdminUtenteDTO informazioni;
    private List<ClienteDTO> utentes;

}
