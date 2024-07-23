package it.hair.flow.dto;

import it.hair.flow.entity.Grant;
import it.hair.flow.entity.InformazioniAdminUtente;
import lombok.Data;

@Data
public class AdminDTO {

    private Integer id;
    private String email;
    private String password;
    private Grant grant;
    private InformazioniAdminUtente informazioni;

}
