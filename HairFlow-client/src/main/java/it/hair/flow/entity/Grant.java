package it.hair.flow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Grant\"")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
