package it.hair.flow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hair.flow.entity.ClienteEntity;
import it.hair.flow.repository.ClienteRepository;
import it.hair.flow.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteEntity findById(Integer id) throws Exception {
		ClienteEntity postFacebook = clienteRepository.findById(id).orElseThrow(()-> new Exception("Not found post Client"));
		return postFacebook;
	}

	@Override
	public List<ClienteEntity> findClients() throws Exception {
		List<ClienteEntity> clients = clienteRepository.findAll();
		if(clients.isEmpty()) {
			throw new Exception("The list of Client is empty");
		} else {
			return clients;
		}
	}

	@Override
	public ClienteEntity addOrUpdateClient(ClienteEntity client) throws Exception {
		ClienteEntity clientAddOrUpdate = clienteRepository.save(client);
		if (!clientAddOrUpdate.getNome().equals(client.getNome()) ) {
			throw new Exception("Insert or update for client failed");
		} else {
			return clientAddOrUpdate;
		}
	}

	@Override
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		ClienteEntity client = findById(id);
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
