package it.hair.flow.controller;

import java.util.List;
import java.util.Map;

import it.hair.flow.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.constant.Constant;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Utente;


@RestController
@RequestMapping(Constant.REQUEST_MAPPING_USER)
@RequiredArgsConstructor
public class UtenteController {

	private final UtenteService utenteService;

	@GetMapping(value = Constant.HAIR_FLOW_PATH + Constant.USER_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Utente findById(@PathVariable Integer id) throws Exception {
		return utenteService.findById(id);
	}

	@GetMapping(value = Constant.HAIR_FLOW_PATH + Constant.USERS_PATH, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Utente> findUsers() throws Exception {
		return utenteService.findUsers();
	}

	@PutMapping(value = Constant.HAIR_FLOW_PATH + Constant.USER_PATH, produces = MediaType.APPLICATION_JSON_VALUE )
	public UtenteDTO updateUser(@RequestBody UtenteDTO user) throws Exception {
		return utenteService.updateUser(user);
	}

	@DeleteMapping(value = Constant.HAIR_FLOW_PATH + Constant.USER_PATH + Constant.DELETE_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(@PathVariable Integer id) throws Exception {
		return utenteService.deleteById(id);
	}

}
