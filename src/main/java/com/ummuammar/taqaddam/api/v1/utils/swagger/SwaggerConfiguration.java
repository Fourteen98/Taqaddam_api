package com.ummuammar.taqaddam.api.v1.utils.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Taqaddam API")
                        .description("This is the backend api documentation for Adpromac")
                        .description("The Taqaddam API is a cutting-edge tool designed to help educational institutions streamline their administrative processes and enhance their overall efficiency. \"Taqaddam,\" which means \"progress\" in Arabic, embodies the core principle of continuous improvement that drives this comprehensive system.\n")
                        .version("1.0")
                        .contact(new Contact().name("Ummu Ammar Islamic School").email("emuhiydeen6@gmail.com").url("")
                        )
                );


    }
}
