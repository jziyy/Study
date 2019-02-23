package com.example.demo.rabbitmq.exchange_fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout2")
public class Fanout_Consumer2 {

    @RabbitHandler
    public void getMessage(String message){
        System.out.println("fanout2 :" + message);
    }
}
