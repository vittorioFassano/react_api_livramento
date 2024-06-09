package org.serratec.backend.livramento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir requisições do frontend
        config.addAllowedOrigin("http://localhost:5173");

        // Permitir os métodos GET, POST, PUT, DELETE e OPTIONS
        config.addAllowedMethod("*");

        // Permitir os headers
        config.addAllowedHeader("*");

        // Permitir credenciais
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
