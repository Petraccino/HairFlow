package it.hair.flow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.AuthRequest;
import it.hair.flow.dto.ClienteDTO;
import it.hair.flow.dto.UtenteDTO;
import it.hair.flow.service.AuthService;

@RestController
@RequestMapping(Constant.REQUEST_MAPPING_AUTH)
public class AuthController {
	
	@Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping(Constant.REGISTER_USER)
    public UtenteDTO registerUser(@RequestBody UtenteDTO utente) {
        return authService.registerUser(utente);
    }
	
	@PostMapping(Constant.LOGIN_USER)
    public UtenteDTO loginUser(@RequestBody AuthRequest authRequest) {
        return authService.loginUser(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping(Constant.REGISTER_CLIENT)
    public ClienteDTO registerClient(@RequestBody ClienteDTO cliente) {
        return authService.registerClient(cliente);
    }
	
	@PostMapping(Constant.LOGIN_CLIENT)
    public ClienteDTO loginClient(@RequestBody AuthRequest authRequest) {
        return authService.loginClient(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping(Constant.LOGIN_ADMIN)
    public AdminDTO loginAdmin(@RequestBody AuthRequest authRequest) {
        return authService.loginAdmin(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping(Constant.GENERATE_TOKEN)
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getEmail());
        } else {
            throw new BadCredentialsException(Constant.BAD_CREDENTIALS_EXCEPTION + authRequest.getEmail());
        }
    }

    @GetMapping(Constant.VALIDATE_TOKEN)
    public String validateToken(@RequestParam String token) {
    	authService.validateToken(token);
    	return token;
    }
}
