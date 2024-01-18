package it.hair.flow.service;

import java.util.List;
import java.util.Map;

import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Utente;

public interface UtenteService {
	public Utente findById(Integer id) throws Exception;
	public List<Utente> findUsers()throws Exception;
	public UtenteDTO updateUser(UtenteDTO client)throws Exception;
	public Map<String, Boolean> deleteById(Integer id) throws Exception;

}
