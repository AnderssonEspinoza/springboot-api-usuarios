package com.demo.crud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestión de Usuarios",
                version = "1.0",
                description = "API REST para gestión de usuarios con Spring Boot"
        )
)
public class OpenApiConfig {
}
