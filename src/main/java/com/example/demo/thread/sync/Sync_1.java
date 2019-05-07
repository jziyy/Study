package com.example.demo.thread.sync;

import java.util.Date;
import java.util.Random;

public class Sync_1 {
    public long a = 10;
    public static long e = 10000;
    public static long gete(){
        return this.a;
    }
    public long get(){
        return gete();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread1 thread11 = new Thread1();
        Thread thread = new Thread(()->{thread1.say();});
        Thread thread12 = new Thread(()->thread1.say());
        thread.start();
        thread12.start();
        thread.join();
        thread12.join();
    }
   static class Thread1{
        private static long a = 1000;
        private static synchronized long geta(){
            a += 1000;
            return a;
        }

        public   void say(){
            try {
                Thread.sleep(geta());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long d = new Date().getTime();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int  i  = 10000;
            while (true){
            System.out.println(d);
            i--;
            }}
    }
}
