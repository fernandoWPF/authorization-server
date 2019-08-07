package br.com.fwpf.authorizationserver.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String role;

	@Override
	public String getAuthority() {
		return role;
	}

}
