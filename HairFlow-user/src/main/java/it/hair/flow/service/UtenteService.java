package it.hair.flow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.hair.flow.entity.Grant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import it.hair.flow.constant.Constant;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.UtenteRepository;

@Service
@RequiredArgsConstructor
public class UtenteService {
	
	private final UtenteRepository utenteRepository;

	private final ObjectMapper objectMapper;
	
	public Utente findById(Integer id) throws Exception {
		Utente utente = utenteRepository.findById(id).orElseThrow(()-> new Exception(Constant.USER_NOT_FOUND));
		return utente;
	}

	public List<Utente> findUsers() throws Exception {
		List<Utente> utentes = utenteRepository.findAll();
		if(utentes.isEmpty()) {
			throw new Exception(Constant.USERS_LIST_EMPTY);
		} else {
			return utentes;
		}
	}
	
	public UtenteDTO updateUser(UtenteDTO utente) throws Exception {
		findById(utente.getId());
		Utente utenteToUpdate = objectMapper.convertValue(utente, Utente.class);
		utenteToUpdate.setGrant(Grant.builder().id(2).build());
		Utente utenteUpdate = utenteRepository.save(utenteToUpdate);
		return objectMapper.convertValue(utenteUpdate, UtenteDTO.class);
	}
	
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Utente utente = findById(id);
		try {
			utenteRepository.deleteById(id);
			map.put(Constant.DELETION_USER +utente.getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
