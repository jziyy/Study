package com.example.demo.thread.sync;

public class Sync_demo1 {

    public static int count = 0;

    public synchronized void add(){
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    public  void  addd() throws InterruptedException {
        final Sync_demo1 sync_demo1 =new Sync_demo1();
        Thread thread1 = new Thread(()->sync_demo1.add());
        Thread thread2 = new Thread(()->sync_demo1.add());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }



}
