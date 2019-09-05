package br.com.fwpf.authorizationserver.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import br.com.fwpf.authorizationserver.config.AuthorizationServerInitializer;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuthorizationServerInitializer.class)
public @interface EnableAuthorizationServerConfigurer {

}
