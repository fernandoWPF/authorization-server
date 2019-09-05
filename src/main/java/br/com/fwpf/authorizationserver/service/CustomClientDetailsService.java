package br.com.fwpf.authorizationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import br.com.fwpf.authorizationserver.exception.AuthorizationServerException;
import br.com.fwpf.authorizationserver.repository.ClientRepository;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository repository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return repository.findByClientId(clientId).orElseThrow(() -> new AuthorizationServerException("Client not found"));
    }

}
