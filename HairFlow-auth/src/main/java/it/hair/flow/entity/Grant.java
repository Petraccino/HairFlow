package it.hair.flow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"Grant\"")
@Data
public class Grant {
	
	@Id
    @Column(nullable = false, updatable = false, name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 6, name = "type_grant")
    private String typeGrant;

    @Column(nullable = false, length = 25, name = "descrizione")
    private String descrizione;
    
    
}
