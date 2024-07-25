package it.hair.flow.dto;
import lombok.Data;

@Data
public class AdminDTO {

    private Integer id;
    private String email;
    private String password;
    private GrantDTO grant;
    private InformazioniAdminUtenteDTO informazioni;

}
