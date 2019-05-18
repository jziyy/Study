package com.example.demo.middleware.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Rabbitmq_Fanout_Config {



    @Bean
    Queue fanout_queue1(){
        return new Queue("fanout1");
    }
    @Bean
    Queue fanout_queue2(){
        return new Queue("fanout2");
    }
    @Bean
    Queue fanout_queue3(){
        return new Queue("fanout3");
    }
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("amq.fanout");
    }
    @Bean
    Binding bindingFanoutQueue1(Queue fanout_queue1, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout_queue1).to(fanoutExchange);
    }
    @Bean
    Binding bindingFanoutQueue2(Queue fanout_queue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout_queue2).to(fanoutExchange);
    }
    @Bean
    Binding bindingFanoutQueue3(Queue fanout_queue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout_queue3).to(fanoutExchange);
    }
}
