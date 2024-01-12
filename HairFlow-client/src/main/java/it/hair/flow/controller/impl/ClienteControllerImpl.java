package it.hair.flow.controller.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.controller.ClienteController;
import it.hair.flow.entity.Cliente;
import it.hair.flow.service.ClienteService;

@RestController
public class ClienteControllerImpl implements ClienteController{
	
	@Autowired
	private ClienteService clienteService;

	@Override
	public Cliente findById(Integer id) throws Exception {
		return clienteService.findById(id);
	}

	@Override
	public List<Cliente> findClients() throws Exception {
		return clienteService.findClients();
	}
	@Override
	public Cliente addClient(Cliente client) throws Exception {
		return clienteService.addOrUpdateClient(client);
	}

	@Override
	public Cliente updateClient(Cliente client) throws Exception {
		return clienteService.addOrUpdateClient(client);
	}


	@Override
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		return clienteService.deleteById(id);
	}


}
