package com.example.demo.middleware.rabbitmq.exchange_direct;

import com.example.demo.middleware.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
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
