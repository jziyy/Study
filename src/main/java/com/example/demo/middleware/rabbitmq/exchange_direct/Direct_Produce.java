package com.example.demo.middleware.rabbitmq.exchange_direct;


import com.example.demo.middleware.rabbitmq.bean.Rabbit_Bean;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Direct_Produce {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Rabbit_Bean rabbit_bean){
        /**
         * 第一个参数：routingKey路由键（绑定的队列名称）
         * 第二个参数：传递的信息
         * 默认交换机
         */
        this.amqpTemplate.convertAndSend("direct_rabbitmq",rabbit_bean);
        /**
         * 第一个参数：交换机类型(此处使用的是直连交换机)
         * 第二个参数：routingKey路由键（绑定的队列名称）
         * 第三个参数：传递的信息
         */
        this.amqpTemplate.convertAndSend("amq.direct","direct_rabbitmq",rabbit_bean);
    }

}
