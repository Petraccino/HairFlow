package it.hair.flow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.hair.flow.entity.Grant;
import it.hair.flow.repository.UtenteClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.entity.Cliente;
import it.hair.flow.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final ObjectMapper objectMapper;
	private final UtenteClienteRepository utenteClienteRepository;

	public Cliente findById(Integer id) throws Exception {
		Cliente client = clienteRepository.findById(id).orElseThrow(()-> new Exception(Constant.CLIENTS_NOT_FOUND));
		return client;
	}
	
	public List<Cliente> findClients() throws Exception {
		List<Cliente> clients = clienteRepository.findAll();
		if(clients.isEmpty()) {
			throw new Exception(Constant.CLIENTS_LIST_EMPTY);
		} else {
			return clients;
		}
	}

	public ClienteDTO updateClient(ClienteDTO client) throws Exception {
		findById(client.getId());
		Cliente clientToUpdate = objectMapper.convertValue(client, Cliente.class);
		clientToUpdate.setGrant(Grant.builder().id(3).build());
		Cliente clientUpdate = clienteRepository.save(clientToUpdate);
		return objectMapper.convertValue(clientUpdate, ClienteDTO.class);
	}

	@Transactional
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Cliente client = findById(id);
		try {
			utenteClienteRepository.deleteByUtenteId(id);
			clienteRepository.deleteById(id);
			map.put(Constant.DELETION_CLIENT +client.getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
