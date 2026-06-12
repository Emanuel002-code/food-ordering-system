package com.jumpstart.food_ordering_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
   class for handling configurations
 */

@Configuration
public class ApplicationConfig {

    @Bean
    public String applicationName() {
        return "Food Ordering System";
    }

}
