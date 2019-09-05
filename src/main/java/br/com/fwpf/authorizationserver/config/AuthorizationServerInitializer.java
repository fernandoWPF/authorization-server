package br.com.fwpf.authorizationserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("authorizationServerInitializer")
@ComponentScan(basePackages = { "br.com.fwpf.authorizationserver.*" })
public interface AuthorizationServerInitializer {

}