package it.hair.flow.dto;

import lombok.Data;

@Data
public class UtenteDTO {
	
	private Integer id;
 	private String email;
    private String password;
    private Integer grant;
    private InformazioniAdminUtenteDTO informazioni;

}
