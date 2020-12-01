package com.business.client.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact("Daniela Sanchez", null,
            "daniela.sanchzcv@gmail.com");
    @Value("${info.app.name}")
    private String title;
    @Value("${info.app.description}")
    private String description;
    @Value("${info.app.version}")
    private String version;

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .contact(CONTACT)
                .version(version)
                .description(description)
                .build();
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("(?!/error).+"))
                .paths(PathSelectors.regex("(?!/actuator).+"))
                .build();
    }
}
