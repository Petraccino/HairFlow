package it.hair.flow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Credential {
	
	@Column(nullable = false, unique = true, length = 55, name = "email")
    private String email;
	
	@Column(nullable = false, length = 150, name = "password")
    private String password;
}
