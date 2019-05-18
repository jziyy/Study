package com.example.demo.middleware.rabbitmq.exchange_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout1")
public class Fanout_Consumer1 {

    @RabbitHandler
    public void getMessage(String message){
        System.out.println("fanout1  :" + message);
    }
}
