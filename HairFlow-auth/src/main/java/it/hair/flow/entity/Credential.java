package it.hair.flow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credential {
	
	@Column(nullable = false, unique = true, length = 55, name = "email")
    private String email;
	
	@JsonIgnore
	@Column(nullable = false, length = 150, name = "password")
    private String password;
}
