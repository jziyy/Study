package com.example.demo.middleware.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *    topic_queue1 的routingkey是"#.jziyy.#"，可以匹配到所有带.jziyy.的队列，topic1，topic2，topic3都包含有.jziyy.字段而topic4不包含，
 *    所以在四个队列同时发送消息是topic_queue1的消费者可以接收到topic1 2 3
 *
 *    如果多个消费者的routingkey满足一个队列名称，此时会同时给两个消费者发送信息
 */
@Configuration
public class Rabbitmq_Topic_Config {

    final static String topic1 = "topic_rabbitmq.jziyy.q1";

    final static String topic2 = "topic_rabbitmq.jziyy.q2";

    final static String topic3 = "topic_rabbitmq.jziyy.q3";

    final static String topic4 = "topic_rabbitmq.q4";


    @Bean
    public Queue topic_queue1(){
        return new Queue(topic1);
    }

    @Bean
    public Queue topic_queue2(){
        return new Queue(topic2);
    }

    @Bean
    public Queue topic_queue3(){
        return new Queue(topic3);
    }

    @Bean
    public Queue topic_queue4(){
        return new Queue(topic4);
    }

    /**
     *  配置交换机的名称"amq.topic"交换机在rabbitmq中是一个topic exchange
     * @return
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("amq.topic");
    }

    /**
     * 绑定队列的routingKey 此配置将队列topic_queue1和交换机exchange和"#.jziyy.#"的路由绑定，传递的参数分别对应上面的
     * 方法名称
     * @param topic_queue1
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchange1(Queue  topic_queue1,TopicExchange exchange){
        return BindingBuilder.bind(topic_queue1).to(exchange).with("#.jziyy.#");
    }


    @Bean
    Binding bindingExchange2(Queue topic_queue2,TopicExchange exchange){
        return BindingBuilder.bind(topic_queue2).to(exchange).with("topic_rabbitmq.jziyy.q2");
    }

    @Bean
    Binding bindingExchange3(Queue topic_queue3,TopicExchange exchange){
        return BindingBuilder.bind(topic_queue3).to(exchange).with("#.q3");
    }

    @Bean
    Binding bindingExchange4(Queue topic_queue4,TopicExchange exchange){
        return BindingBuilder.bind(topic_queue4).to(exchange).with("topic_rabbitmq.q4");
    }




}
