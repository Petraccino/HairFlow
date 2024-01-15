package it.hair.flow.config.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.hair.flow.entity.Credential;

public class CredentialDetails implements UserDetails{
	
	private static final long serialVersionUID = -2967660433578527724L;
	private String email;;
    private String password;
	
    public CredentialDetails(Credential credential) {
        this.email = credential.getEmail();
        this.password = credential.getPassword();
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
