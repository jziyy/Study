package com.example.demo.middleware.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rabbitmq_Direct_Config {

    final static String direct = "direct_rabbitmq";


    @Bean
    public Queue direct_queue(){
        return new Queue(direct);
    }




}
