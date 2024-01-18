package it.hair.flow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Utente;
import it.hair.flow.service.UtenteService;


@RestController
@RequestMapping("/user")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping(value = "/hair-flow/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Utente findById(@PathVariable Integer id) throws Exception {
		return utenteService.findById(id);
	}

	@GetMapping(value = "/hair-flow/users", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Utente> findUsers() throws Exception {
		return utenteService.findUsers();
	}

	@PutMapping(value = "/hair-flow/user", produces = MediaType.APPLICATION_JSON_VALUE )
	public UtenteDTO updateUser(@RequestBody UtenteDTO user) throws Exception {
		return utenteService.updateUser(user);
	}

	@DeleteMapping(value = "/hair-flow/user/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(@PathVariable Integer id) throws Exception {
		return utenteService.deleteById(id);
	}

}
