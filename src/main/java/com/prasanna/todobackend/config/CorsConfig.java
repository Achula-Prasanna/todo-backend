package com.prasanna.todobackend.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200"); // Allow requests from this origin
        config.addAllowedHeader("*"); // Allow all headers
        config.addAllowedMethod("*");
//        config.addAllowedMethod("GET"); // Allow GET requests
//        config.addAllowedMethod("POST"); // Allow POST requests
//        config.addAllowedMethod("PUT"); // Allow PUT requests

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
