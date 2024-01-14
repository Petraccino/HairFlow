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

import it.hair.flow.entity.Cliente;
import it.hair.flow.service.ClienteService;

@RestController
@RequestMapping("/client")
public class ClienteController{
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/hair-flow/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Cliente findById(Integer id) throws Exception {
		return clienteService.findById(id);
	}

	@GetMapping(value = "/hair-flow/clients", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Cliente> findClients() throws Exception {
		return clienteService.findClients();
	}
	@PostMapping(value = "/hair-flow/client", produces = MediaType.APPLICATION_JSON_VALUE )
	public Cliente addClient(Cliente client) throws Exception {
		return clienteService.addOrUpdateClient(client);
	}

	@PutMapping(value = "/hair-flow/client", produces = MediaType.APPLICATION_JSON_VALUE )
	public Cliente updateClient(Cliente client) throws Exception {
		return clienteService.addOrUpdateClient(client);
	}

	@DeleteMapping(value = "/hair-flow/client/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		return clienteService.deleteById(id);
	}

}
