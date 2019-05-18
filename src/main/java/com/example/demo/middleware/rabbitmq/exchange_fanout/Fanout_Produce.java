package com.example.demo.middleware.rabbitmq.exchange_fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fanout_Produce {
    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 此处的配置routingKey必须进行配置，配置内容随意不影响，可以为“”。
     * @param message
     */
    public void send(String message){
        this.amqpTemplate.convertAndSend("amq.fanout","61616","发送一条消息" + message);
    }

}
