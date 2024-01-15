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

import it.hair.flow.dto.AuthRequest;
import it.hair.flow.entity.Admin;
import it.hair.flow.entity.Cliente;
import it.hair.flow.entity.Utente;
import it.hair.flow.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/register/user")
    public Utente registerUser(@RequestBody Utente utente) {
        return authService.registerUser(utente);
    }
	
	@PostMapping("/login/user")
    public Utente loginUser(@RequestBody AuthRequest authRequest) {
        return authService.loginUser(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping("/register/client")
    public Cliente registerClient(@RequestBody Cliente cliente) {
        return authService.registerClient(cliente);
    }
	
	@PostMapping("/login/client")
    public Cliente loginClient(@RequestBody AuthRequest authRequest) {
        return authService.loginClient(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping("/login/admin")
    public Admin loginAdmin(@RequestBody AuthRequest authRequest) {
        return authService.loginAdmin(authRequest.getEmail(), authRequest.getPassword());
    }
	
	@PostMapping("/generate/token")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getEmail());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @GetMapping("/validate/token")
    public String validateToken(@RequestParam String token) {
    	authService.validateToken(token);
    	return token;
    }
}
