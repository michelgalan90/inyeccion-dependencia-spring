package com.galan.springbootinyeccion.app.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean("pollitobean")
    public String dameTextO(){
        return "Hola este sera un Bean inyectado por la anotacion @Bean, es muy parecido a usar anotacion @Component" +
                " pero se usa normalmente para registrar un Component desde un metodo, usando un metodo, no usando la clase" +
                " porque la anotacion @Component se usa en type o sea en clases, pero con @Bean la puedo usar en meetodos" +
                " entonces usando @Configuration y luego @Bean en el metodo, registrara esos Bean como componentes en el " +
                " contenedor, probemos este ejemplo";
    }
}
