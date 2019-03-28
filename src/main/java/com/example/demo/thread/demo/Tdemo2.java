package com.example.demo.thread.demo;

public class Tdemo2 {
    public static void main(String[] args) {
        while (true){
            Thread thread =new Thread(()->{
                System.out.println("aaaa");
            });
            thread.run();
        }
    }
}
