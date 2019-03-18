package com.example.demo.thread.demo;

public class ThreadDemo1 {
    private static volatile long count = 0;
    private void  add(){
        int idx = 0;
        while (idx++ < 1000){
            count++;
        }
    }

    public void  addd(){
        final ThreadDemo1 demo1 =new ThreadDemo1();
        Thread thread1 = new Thread(()->demo1.add());
        Thread thread2 = new Thread(()->demo1.add());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }



}
