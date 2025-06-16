// src/main/java/com/katiasantanabeauty/api/config/WebConfig.java
package com.katiasantana.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
          .addMapping("/api/**")                  // aplica a todos os endpoints da API
          .allowedOriginPatterns("*")             // permite qualquer domínio
          .allowedMethods("*")                    // permite todos os métodos (GET, POST, etc)
          .allowedHeaders("*")                    // permite todos os headers
          .allowCredentials(false);               // sem credenciais (cookies, auth)
    }
}