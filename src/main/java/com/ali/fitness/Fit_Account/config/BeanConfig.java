package com.ali.fitness.Fit_Account.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }



}
