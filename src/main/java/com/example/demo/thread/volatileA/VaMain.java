package com.example.demo.thread.volatileA;

public class VaMain {
    public static void main(String[] args) throws InterruptedException {
        ChangeUtil changeUtil =new ChangeUtil();
        Thread t2 =new Thread(()->changeUtil.read());
        Thread t1 =new Thread(()->changeUtil.write());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
