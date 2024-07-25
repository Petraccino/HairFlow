package it.hair.flow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.entity.Cliente;
import it.hair.flow.repository.ClienteRepository;
import it.hair.flow.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Cliente findById(Integer id) throws Exception {
		Cliente client = clienteRepository.findById(id).orElseThrow(()-> new Exception(Constant.CLIENTS_NOT_FOUND));
		return client;
	}

	@Override
	public List<Cliente> findClients() throws Exception {
		List<Cliente> clients = clienteRepository.findAll();
		if(clients.isEmpty()) {
			throw new Exception(Constant.CLIENTS_LIST_EMPTY);
		} else {
			return clients;
		}
	}

	@Override
	public ClienteDTO updateClient(ClienteDTO client) throws Exception {
		Cliente cliDaAggiornare = findById(client.getId());
		Cliente clientUpdate = modelMapper.map(client, Cliente.class);
		clienteRepository.save(clientUpdate);
		return modelMapper.map(clientUpdate, ClienteDTO.class);
	}

	@Override
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Cliente client = findById(id);
		try {
			clienteRepository.deleteById(id);
			map.put(Constant.DELETION_CLIENT +client.getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
