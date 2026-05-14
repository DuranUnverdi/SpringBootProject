package com.spring_rest_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${openapi.server-url:http://localhost:8080}")
    private String serverUrl;

    @Bean
    public OpenAPI springRestApiOpenAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url(serverUrl).description("Uygulama adresi")))
                .info(new Info()
                        .title("Spring REST API")
                        .description("Öğrenme projesi: öğrenci, müşteri, ev ve departman/çalışan REST uçları.")
                        .version("1.0")
                        .contact(new Contact().name("Spring Boot Project")));
    }
}
