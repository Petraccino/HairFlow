package it.hair.flow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.hair.flow.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	Optional<Admin> findByEmailAndPassword(String email, String password);
}
