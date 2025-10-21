package com.example.drivex_be.config;

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
        config.setAllowCredentials(true); // Cho phép gửi cookie nếu cần
        config.addAllowedOrigin("http://localhost:3000"); // Cho phép origin của frontend
        config.addAllowedHeader("*"); // Cho phép tất cả header
        config.addAllowedMethod("*"); // Cho phép tất cả phương thức (GET, POST, OPTIONS, etc.)
        source.registerCorsConfiguration("/**", config); // Áp dụng cho tất cả endpoint
        return new CorsFilter(source);
    }
}
