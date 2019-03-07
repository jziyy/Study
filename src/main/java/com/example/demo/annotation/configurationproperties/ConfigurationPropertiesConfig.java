package com.example.demo.annotation.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationPropertiesConfig {
    @Bean
    @ConfigurationProperties
    public ConfigurationPropertiesBean getBean(){
        return new ConfigurationPropertiesBean();
    }

}
