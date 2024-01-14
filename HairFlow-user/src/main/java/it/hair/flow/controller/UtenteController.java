package it.hair.flow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.entity.Utente;
import it.hair.flow.service.UtenteService;


@RestController
@RequestMapping("/user")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping(value = "/hair-flow/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Utente findById(Integer id) throws Exception {
		return utenteService.findById(id);
	}

	@GetMapping(value = "/hair-flow/users", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Utente> findUsers() throws Exception {
		return utenteService.findUsers();
	}
	@PostMapping(value = "/hair-flow/user", produces = MediaType.APPLICATION_JSON_VALUE )
	public Utente addUser(Utente user) throws Exception {
		return utenteService.addOrUpdateUser(user);
	}

	@PutMapping(value = "/hair-flow/user", produces = MediaType.APPLICATION_JSON_VALUE )
	public Utente updateUser(Utente user) throws Exception {
		return utenteService.addOrUpdateUser(user);
	}

	@DeleteMapping(value = "/hair-flow/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		return utenteService.deleteById(id);
	}

}
