package it.hair.flow.controller;

import java.util.List;
import java.util.Map;

import it.hair.flow.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.entity.Cliente;

@RestController
@RequestMapping(Constant.REQUEST_MAPPING_CLIENT)
@RequiredArgsConstructor
public class ClienteController{

	private final ClienteService clienteService;

	@GetMapping(value = Constant.HAIR_FLOW_PATH + Constant.CLIENT_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Cliente findById(@PathVariable Integer id) throws Exception {
		return clienteService.findById(id);
	}

	@GetMapping(value = Constant.HAIR_FLOW_PATH + Constant.CLIENTS_PATH , produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Cliente> findClients() throws Exception {
		return clienteService.findClients();
	}

	@PutMapping(value = Constant.HAIR_FLOW_PATH + Constant.CLIENT_PATH + "", produces = MediaType.APPLICATION_JSON_VALUE )
	public ClienteDTO updateClient(@RequestBody ClienteDTO client) throws Exception {
		return clienteService.updateClient(client);
	}

	@DeleteMapping(value = Constant.HAIR_FLOW_PATH + Constant.CLIENT_PATH + Constant.DELETE_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(@PathVariable Integer id) throws Exception {
		return clienteService.deleteById(id);
	}

}
