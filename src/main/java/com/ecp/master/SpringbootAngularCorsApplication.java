package com.ecp.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootAngularCorsApplication {
    public static void main (String[] args){
        SpringApplication.run(SpringbootAngularCorsApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            public void addCoreMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedOrigins("http://180.183.246.177:1115");
            }
        };
    }
}
