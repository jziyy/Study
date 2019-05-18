package com.example.demo.middleware.rabbitmq.exchange_topic;

import com.example.demo.middleware.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_rabbitmq.jziyy.q1")
public class Topic_Consumer {

    @RabbitHandler
    public void receive(Rabbit_Bean rabbit_bean){
        System.out.println("topic_rabbitmq.jziyy.q1:   " + rabbit_bean);
    }


}
