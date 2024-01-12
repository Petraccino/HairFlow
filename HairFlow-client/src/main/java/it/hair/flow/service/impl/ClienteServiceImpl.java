package it.hair.flow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hair.flow.entity.Cliente;
import it.hair.flow.repository.ClienteRepository;
import it.hair.flow.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente findById(Integer id) throws Exception {
		Cliente postFacebook = clienteRepository.findById(id).orElseThrow(()-> new Exception("Not found post Client"));
		return postFacebook;
	}

	@Override
	public List<Cliente> findClients() throws Exception {
		List<Cliente> clients = clienteRepository.findAll();
		if(clients.isEmpty()) {
			throw new Exception("The list of Client is empty");
		} else {
			return clients;
		}
	}

	@Override
	public Cliente addOrUpdateClient(Cliente client) throws Exception {
		Cliente clientAddOrUpdate = clienteRepository.save(client);
		if (!clientAddOrUpdate.getNome().equals(client.getNome()) ) {
			throw new Exception("Insert or update for client failed");
		} else {
			return clientAddOrUpdate;
		}
	}

	@Override
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Cliente client = findById(id);
		try {
			clienteRepository.deleteById(id);
			map.put("Deletion: "+client.getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
