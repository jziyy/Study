package com;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;
@Order(1)
@Component
public class BeforeApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws InterruptedException {
        int hours = new Date().getHours();
        System.out.println(hours);
        while (true) {
            if (new Date().getHours() == 12) {
                Thread.sleep(1000);
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("-------------------------");
                System.out.println("-------------------------");


                System.out.println("执行了");
                Thread.sleep(3600000);
            }
            else {
                Thread.sleep(3600000);
            }
        }
    }
}
