package com.example.demo.middleware.rabbitmq.exchange_topic;

import com.example.demo.middleware.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_rabbitmq.jziyy.q3")
public class Topic_Consumer2 {

    @RabbitHandler
    public void receive1(Rabbit_Bean rabbit_bean){
        System.out.println("topic_rabbitmq.jziyy.q3:     " + rabbit_bean);
    }
}
