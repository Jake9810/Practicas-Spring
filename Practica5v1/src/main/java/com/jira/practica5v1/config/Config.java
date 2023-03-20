package com.jira.practica5v1.config;

import com.jira.practica5v1.repository.ImpProductRepository;
import com.jira.practica5v1.repository.ProductRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ProductRespository productRespository(){
        return new ImpProductRepository();
    }
}
