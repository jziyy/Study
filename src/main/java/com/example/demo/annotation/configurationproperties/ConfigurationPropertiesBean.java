package com.example.demo.annotation.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Data
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "user1.bean")
public class ConfigurationPropertiesBean {
    private String name;
    private String password;
    private String state;

}
