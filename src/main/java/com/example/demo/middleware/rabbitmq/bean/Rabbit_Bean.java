package com.example.demo.middleware.rabbitmq.bean;

import lombok.Data;

import java.io.Serializable;


@Data
public class Rabbit_Bean implements Serializable {

    private String name;
    private String password;
}
