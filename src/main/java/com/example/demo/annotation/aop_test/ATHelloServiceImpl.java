package com.example.demo.annotation.aop_test;

import org.springframework.util.StringUtils;

public class ATHelloServiceImpl implements ATHelloService {
    @Override
    public void sayHello(String name) {
        if (StringUtils.isEmpty(name)){
            throw new RuntimeException("name is null");
        }
        System.out.println("hello   " + name);
    }
}
