package it.hair.flow.service;

import java.util.List;
import java.util.Map;

import it.hair.flow.entity.ClienteEntity;

public interface ClienteService {
	public ClienteEntity findById(Integer id) throws Exception;
	public List<ClienteEntity> findClients()throws Exception;
	public ClienteEntity addOrUpdateClient(ClienteEntity client)throws Exception;
	public Map<String, Boolean> deleteById(Integer id) throws Exception;

}
