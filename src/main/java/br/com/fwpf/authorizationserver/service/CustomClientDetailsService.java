package br.com.fwpf.authorizationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import br.com.fwpf.authorizationserver.repository.UserRepository;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) {
		return repository.findByUsername(clientId).orElseThrow(() -> new RuntimeException("User not found."));
	}

}
