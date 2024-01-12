package it.hair.flow.service;

import java.util.List;
import java.util.Map;

import it.hair.flow.entity.Cliente;

public interface ClienteService {
	public Cliente findById(Integer id) throws Exception;
	public List<Cliente> findClients()throws Exception;
	public Cliente addOrUpdateClient(Cliente client)throws Exception;
	public Map<String, Boolean> deleteById(Integer id) throws Exception;

}
