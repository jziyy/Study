package com.example.demo.middleware.rabbitmq.exchange_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout3")
public class Fanout_Consumer3 {

    @RabbitHandler
    public void getMessage(String message){
        System.out.println("fanout3  :" + message);
    }
}
