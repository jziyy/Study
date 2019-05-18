package com.example.demo.middleware.rabbitmq.exchange_topic;

import com.example.demo.middleware.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Topic_Produce {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send1(Rabbit_Bean rabbit_bean){
        amqpTemplate.convertAndSend("amq.topic","topic_rabbitmq.jziyy.q1",rabbit_bean);

    }
    public void send2(Rabbit_Bean rabbit_bean){
        amqpTemplate.convertAndSend("amq.topic","topic_rabbitmq.jziyy.q2",rabbit_bean);

    }
    public void send3(Rabbit_Bean rabbit_bean){
        amqpTemplate.convertAndSend("amq.topic","topic_rabbitmq.jziyy.q3",rabbit_bean);

    }
    public void send4(Rabbit_Bean rabbit_bean){
        amqpTemplate.convertAndSend("amq.topic","topic_rabbitmq.q4",rabbit_bean);

    }


}
