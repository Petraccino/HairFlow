package it.hair.flow.repository;

import java.util.Optional;

import it.hair.flow.entity.Admin;

public interface AdminRepository extends CredentialRepository<Admin, Integer>{
	Optional<Admin> findByEmail(String email);

}
