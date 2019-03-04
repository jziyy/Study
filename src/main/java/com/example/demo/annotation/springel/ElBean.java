package com.example.demo.annotation.springel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ElBean {
    @Value("#{userbean1.name?.toUpperCase()}")
    private String name;
    @Value("#{T(System).currentTimeMillis()}")
    private String time;
    @Value("#{9.333}")
    private float score;
    @Value("#{userbean2.password.toUpperCase()}")
    private String password;
}
