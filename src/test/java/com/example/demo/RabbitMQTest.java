package com.example.demo;

import com.example.demo.rabbitmq.bean.Rabbit_Bean;
import com.example.demo.rabbitmq.exchange_direct.Direct_Produce;
import com.example.demo.rabbitmq.exchange_fanout.Fanout_Produce;
import com.example.demo.rabbitmq.exchange_topic.Topic_Produce;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RabbitMQTest extends DemoApplicationTests {

    @Autowired
    private Direct_Produce direct_produce;

    @Autowired
    private Topic_Produce topic_produce;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Fanout_Produce fanout_produce;

    @Test
    public void receive(){
        Rabbit_Bean rabbit_bean = (Rabbit_Bean) amqpTemplate.receiveAndConvert("direct_rabbitmq");
        //System.out.println(rabbit_bean);
    }

    public List<Rabbit_Bean> getList(){
        List<Rabbit_Bean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Rabbit_Bean rabbit_bean = new Rabbit_Bean();
            rabbit_bean.setName("第" + i + "zu");
            rabbit_bean.setPassword("topicPasswordAAA" + i);
            list.add(rabbit_bean);
        }
        return list;
    }

    public List<String> getStrList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("消息" + i);
        }
        return list;
    }

    /**
     * fanout交换机
     */
    @Test
    public void fanout_exchange(){
        List<String> list = getStrList();
        list.forEach(s -> fanout_produce.send(s));
    }
    public void receive(int i){
        while (true){
            System.out.println(i);
        }
    }
    public List<Thread> getThreadList(){
        List<Thread> list =new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int a =i;
            Thread thread =new Thread(()->{
                while (true) {
                    //System.out.println("线程"+ a +"调用");
                    this.receive();
                }
            });

            list.add(thread);
        }
        return list;
    }
    @Test
    public void threddemo() throws InterruptedException {

        System.out.println("程序运行了");
        List<Thread> list =getThreadList();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }

        System.out.println("程序结束了");
    }


    /**
     * direct交换机
     */
    @Test
    public void direct_exchange() throws InterruptedException {
        Thread thread =new Thread(()->{
            while (true) {
                System.out.println("线程0调用");
                this.receive();
            }
        });
        Thread thread1 =new Thread(()->{
            while (true){
            System.out.println("线程1调用");
            this.receive();
            }
        });
        Thread thread2 =new Thread(()->{
            while (true) {
                System.out.println("线程2调用");
                this.receive();
            }
        });
        Thread thread3 =new Thread(()->{
            while (true) {
                System.out.println("线程3调用");
                this.receive();
            }
        });
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

    }

    public void send(){
        int i = 0;
        while(i <= 1000000) {
            Rabbit_Bean rabbit_bean = new Rabbit_Bean();
            rabbit_bean.setName("第" + i + "zu");
            rabbit_bean.setPassword("topicPasswordAAA" + i);
            direct_produce.send(rabbit_bean);
            i++;
        }
    }
    /**
     * topic交换机
     */
    @Test
    public void topic_exchange(){
        List<Rabbit_Bean> list = getList();
        list.forEach(s ->{
            topic_produce.send1(s);
            topic_produce.send2(s);
            topic_produce.send3(s);
            topic_produce.send4(s);
        });

    }

    @Test
    public void topicConsumer(){
        while (true){
        Rabbit_Bean rabbit_bean = (Rabbit_Bean) amqpTemplate.receiveAndConvert("topic_rabbitmq.jziyy.q1");
        System.out.println(rabbit_bean);
    }
    }

}
