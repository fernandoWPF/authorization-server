# Authorization Server Provider
> Responsável por prover a autenticação de usuários e geração de tokens de acesso

Utilizando o protocolo [OAuth2](https://oauth.net/2/), mediante um ```clientId``` e um ```secret``` válidos fornecido juntamente com __grant_type__ [client_credentials](https://oauth.net/2/grant-types/client-credentials/), o servidor autenticará e forncerá um token de acesso válido contendo as permissões do usuário.

## Como utilizar
### 1 - Clonar o projeto do git
```
git clone https://github.com/fernandoWPF/authorization-server.git
```
### 2 - Buildar o projeto
```
mvn clean install
```
### 3 - Importar o artefato gerado dentro do resource que utilizará a autenticação
```
	<dependency>
		<groupId>br.com.fwpf.security</groupId>
		<artifactId>authorization-server</artifactId>
		<version>1.0.0</version>
		<classifier>exec</classifier>
	</dependency>
```

### 4 - Anotar a classe principal do resource server com _@EnableAuthorizationServerConfigurer_. Exemplo:
```
package br.com.fwpf.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import br.com.fwpf.authorizationserver.annotation.EnableAuthorizationServerConfigurer;

@SpringBootApplication(exclude = { MongoAutoConfiguration.class })
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAuthorizationServerConfigurer
public class ApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApisApplication.class);
    }

}
```
### 5 - Definir o datasource do authorization-server dentro do arquivo de propriedades(arquivo .properties ou .yml) do resource server, da seguinte forma:
```
authorization:
  ds:
    uri: <URI de acesso ao banco de dados onde se encontra os usuários cadastrados>
```
#### 5.1 - É necessário realizar a configuração do DataSource de forma manual. Veja [aqui](https://github.com/fernandoWPF/authorization-server/blob/master/src/main/java/br/com/fwpf/authorizationserver/datasource/DataSourceConfiguration.java) como o authorization-server está configurado. Da mesma forma deverá ser contruído o DataSource do resource server. Veja que na classe principal, excluímos a configuração automática do Mongo.

## Construído com

##
* [JDK 11](https://www.oracle.com/java/)
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework](https://spring.io/) - Development Framework
* [Mongo DB](https://www.mongodb.com/) - Cloud Database