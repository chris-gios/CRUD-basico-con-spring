package com.chriscorp.crud.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration//Le indica a spring que la clase es de configuracion
@EnableWebSecurity//configuracion basica de seguridad
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception { //que se va a controlar a traves de spring security que son las exception

        http.authorizeRequests()//se van a autorizar las peticiones de tipo...
                .anyRequest().authenticated()//peticiones de manera autenticada
                .and()
                .formLogin()//por medio de un formulario de login
                .and().httpBasic();//y un metodo de autenticacion http basic
        http.csrf().disable();//Desactiva el CSRF (Cross-Site Request Forgery)
        http.headers().frameOptions().disable();
    }

}
