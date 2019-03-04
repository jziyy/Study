package com.example.demo.annotation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Jz implements Persion {
    @Value("jz")
    private String name;
    @Override
    public void speak() {
        System.out.println("my name is " + name);
    }
}
