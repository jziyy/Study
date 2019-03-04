package com.example.demo.annotation.value;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PropertySource(value = "classpath:application.properties")
public class Value_bean {
    @Value("${user.bean.name}")
    private String name;
    @Value("${user.bean.password}")
    private String password;
    @Value("${user.bean.state}")
    private String state;

}
