package it.hair.flow.repository;

import java.util.Optional;

import it.hair.flow.entity.Admin;

public interface AdminRepository extends CredentialRepository<Admin, Integer>{
	Optional<Admin> findByEmailAndPassword(String email, String password);
	Optional<Admin> findByEmail(String email);

}
