package it.hair.flow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public ClienteDTO findById(Integer id) throws Exception {
		Cliente client = clienteRepository.findById(id).orElseThrow(()-> new Exception(Constant.CLIENTS_NOT_FOUND));
		return objectMapper.convertValue(client, ClienteDTO.class);
	}
	
	public List<ClienteDTO> findClients() throws Exception {
		List<Cliente> clients = clienteRepository.findAll();
		if(clients.isEmpty()) {
			throw new Exception(Constant.CLIENTS_LIST_EMPTY);
		} else {
			return clients.stream().map(cliente -> objectMapper.convertValue(cliente, ClienteDTO.class)).collect(Collectors.toList());
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
		ClienteDTO client = findById(id);
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
