package it.hair.flow.controller;

import java.util.Map;

import it.hair.flow.dto.AdminDTO;
import it.hair.flow.entity.Admin;
import it.hair.flow.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.constant.Constant;


@RestController
@RequestMapping(Constant.REQUEST_MAPPING_ADMIN)
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;

	@GetMapping(value = Constant.HAIR_FLOW_PATH + Constant.ADMIN_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Admin findById(@PathVariable Integer id) throws Exception {
		return adminService.findById(id);
	}

	@PutMapping(value = Constant.HAIR_FLOW_PATH + Constant.ADMIN_PATH, produces = MediaType.APPLICATION_JSON_VALUE )
	public AdminDTO updateUser(@RequestBody AdminDTO user) throws Exception {
		return adminService.updateUser(user);
	}

	@DeleteMapping(value = Constant.HAIR_FLOW_PATH + Constant.ADMIN_PATH + Constant.DELETE_PATH + Constant.ID_PATH_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Map<String, Boolean> deleteById(@PathVariable Integer id) throws Exception {
		return adminService.deleteById(id);
	}

}
