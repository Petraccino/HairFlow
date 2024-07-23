package it.hair.flow.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.hair.flow.dto.AdminDTO;
import it.hair.flow.entity.Admin;
import it.hair.flow.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import it.hair.flow.constant.Constant;

@Service
@RequiredArgsConstructor
public class AdminService {
	
	private final AdminRepository adminRepository;
	private final ObjectMapper mapper;

	public AdminDTO findById(Integer id) throws Exception {
		Admin admin = adminRepository.findById(id).orElseThrow(()-> new Exception(Constant.ADMIN_NOT_FOUND));
		return mapper.convertValue(admin, AdminDTO.class);
	}

}
