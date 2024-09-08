package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permitir CORS em todas as rotas
                .allowedOrigins("http://localhost:4200")  // Permitir requisições de localhost:4200 (Angular)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Incluindo o método OPTIONS para preflight
                .allowedHeaders("*")  // Permitir todos os cabeçalhos
                .allowCredentials(true)  // Permitir envio de credenciais (como cookies ou tokens)
                .maxAge(3600);  // Tempo de cache para a resposta preflight
    }
}