package com.business.client.service.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    private static final String TITLE = "CLIENT REST API";
    private static final Contact CONTACT = new Contact("CLIENT SERVICE", null,
            "julian.markowskyj@gmail.com.ar");
    private static final String DESCRIPTION = "Servicio para insertar clientes";
    private static final String SERVICE_VERSION = "0.0.1";

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .contact(CONTACT)
                .version(SERVICE_VERSION)
                .description(DESCRIPTION)
                .build();
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/business/client/.*"))
                .build();
    }
}
