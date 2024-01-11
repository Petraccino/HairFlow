package it.hair.flow.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.hair.flow.entity.ClienteEntity;


@RequestMapping("/client")
public interface ClienteController {
	
	@GetMapping(value = "/hair-flow/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ClienteEntity findById(@PathVariable Integer id) throws Exception;
	@GetMapping(value = "/hair-flow/clients", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<ClienteEntity> findClients()throws Exception;
	@PostMapping(value = "/hair-flow/client", produces = MediaType.APPLICATION_JSON_VALUE )
	public ClienteEntity addClient(@RequestBody ClienteEntity client)throws Exception;
	@PutMapping(value = "/hair-flow/client", produces = MediaType.APPLICATION_JSON_VALUE )
	public ClienteEntity updateClient(@RequestBody ClienteEntity client)throws Exception;
	@DeleteMapping(value = "/hair-flow/client/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(@PathVariable Integer id) throws Exception;

}
