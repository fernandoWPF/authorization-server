package br.com.fwpf.authorizationserver.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fwpf.authorizationserver.domain.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	Optional<Client> findByClientId(String clientId);

}
