package br.com.fwpf.authorizationserver.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientURI;

import br.com.fwpf.authorizationserver.repository.ClientRepository;

@Configuration("dsAuthorizationServer")
@EnableMongoRepositories(basePackageClasses = ClientRepository.class, mongoTemplateRef = "authorizationServerMongoTemplate")
public class DataSourceConfiguration {

    @Value("${authorization.ds.uri}")
    private String uri;

    @Primary
    @Bean(name = "authorizationServerMongoTemplate")
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

    @Primary
    @Bean("authorizationServerMongoDbFactory")
    public MongoDbFactory mongoDbFactory() {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        return new SimpleMongoDbFactory(mongoClientURI);
    }

}
