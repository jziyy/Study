package com.example.demo.annotation.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@Component
@Primary
public class YY implements Persion{
    @Value("yy")
    private String name;

    @Override
    public void speak() {
        System.out.println("my name is " + name);
    }
}
