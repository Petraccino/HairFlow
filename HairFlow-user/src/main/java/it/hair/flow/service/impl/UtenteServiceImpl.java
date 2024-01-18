package it.hair.flow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.entity.InformazioniAdminUtente;
import it.hair.flow.entity.Utente;
import it.hair.flow.repository.UtenteRepository;
import it.hair.flow.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	private UtenteRepository utenteRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Utente findById(Integer id) throws Exception {
		Utente utente = utenteRepository.findById(id).orElseThrow(()-> new Exception("Not found User"));
		return utente;
	}

	@Override
	public List<Utente> findUsers() throws Exception {
		List<Utente> utentes = utenteRepository.findAll();
		if(utentes.isEmpty()) {
			throw new Exception("The list of User is empty");
		} else {
			return utentes;
		}
	}

	@Override
	public UtenteDTO updateUser(UtenteDTO utente) throws Exception {
		Utente uteDaAggiornare = findById(utente.getId());
		uteDaAggiornare.setInformazioni(modelMapper.map(utente.getInformazioni(), InformazioniAdminUtente.class));
		utenteRepository.save(uteDaAggiornare);
		return modelMapper.map(uteDaAggiornare, UtenteDTO.class);
	}

	@Override
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Utente utente = findById(id);
		try {
			utenteRepository.deleteById(id);
			map.put("Deletion: "+utente.getInformazioni().getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
