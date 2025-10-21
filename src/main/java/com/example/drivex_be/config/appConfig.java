package com.example.drivex_be.config;

import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

public class appConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
