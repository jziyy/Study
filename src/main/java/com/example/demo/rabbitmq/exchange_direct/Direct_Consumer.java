package com.example.demo.rabbitmq.exchange_direct;

import com.example.demo.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "direct_rabbitmq")
public class Direct_Consumer {

    @RabbitHandler
    public void receive(Rabbit_Bean rabbit_bean){
        System.out.println(rabbit_bean.getName() + rabbit_bean.getPassword());
        System.out.println(rabbit_bean);
    }
}
