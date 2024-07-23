package it.hair.flow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.hair.flow.entity.Admin;
import it.hair.flow.entity.InformazioniAdminUtente;
import it.hair.flow.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import it.hair.flow.constant.Constant;
import it.hair.flow.dto.AdminDTO;

@Service
@RequiredArgsConstructor
public class AdminService {
	
	
	private AdminRepository adminRepository;
	
	public Admin findById(Integer id) throws Exception {
		Admin admin = adminRepository.findById(id).orElseThrow(()-> new Exception(Constant.ADMIN_NOT_FOUND));
		return admin;
	}

	
	public List<Admin> findUsers() throws Exception {
		List<Admin> admins = adminRepository.findAll();
		if(admins.isEmpty()) {
			throw new Exception(Constant.ADMINS_LIST_EMPTY);
		} else {
			return admins;
		}
	}

	
	public AdminDTO updateUser(AdminDTO Admin) throws Exception {
		Admin adminDaAggiornare = findById(Admin.getId());
		adminDaAggiornare.setInformazioni(modelMapper.map(Admin.getInformazioni(), InformazioniAdminUtente.class));
		adminRepository.save(adminDaAggiornare);
		return modelMapper.map(adminDaAggiornare, AdminDTO.class);
	}

	
	public Map<String, Boolean> deleteById(Integer id) throws Exception {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		Admin Admin = findById(id);
		try {
			adminRepository.deleteById(id);
			map.put(Constant.DELETION_ADMIN + Admin.getInformazioni().getNome(), Boolean.TRUE);
		} catch(IllegalArgumentException iae) {
			map.put("Deletion", Boolean.FALSE);
			iae.printStackTrace();
		}
		return map;
	}

}
