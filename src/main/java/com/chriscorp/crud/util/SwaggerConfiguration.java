package com.chriscorp.crud.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//le dice a spring que es una clase de configuracion
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket documentation(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))//se enlaza con las clases que tengan @RestController
                .paths(PathSelectors.any())//busqueda de todos los elementos que son servicos web
                .build();
    }
}
