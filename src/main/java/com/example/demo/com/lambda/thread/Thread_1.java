package com.example.demo.com.lambda.thread;

public class Thread_1 {
    public static void main(String[] args) {
        new Thread(()-> {
            while(true){
            System.out.println(111);}
        }).start();
        new Thread(()-> {
            while(true){
                System.out.println(222);}
        }).start();
        new Thread(()-> {
            while(true){
                System.out.println(333);}
        }).start();
        new Thread(()-> {
            while(true){
                System.out.println(4444);}
        }).start();


    }
}
