package br.com.fwpf.authorizationserver.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fwpf.authorizationserver.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUsername(String username);

}
