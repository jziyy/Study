package com.example.demo.annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource("classpath:application.properties")
public class Value_Bean1 {
    @Value("${user.bean.name}")
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    @Value("${user.bean.password}")
    public void setPassword(String password) {
        this.password = password;
    //    System.out.println(password);
    }

    @Override
    public String toString() {
        return "Value_Bean1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
