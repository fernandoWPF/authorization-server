package br.com.fwpf.authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class })
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
