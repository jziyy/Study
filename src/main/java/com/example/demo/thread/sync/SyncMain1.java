package com.example.demo.thread.sync;

import java.util.ArrayList;
import java.util.List;

public class SyncMain1 {
    public static int value = 0;
    public synchronized void addValue(){

        for (int i = 0; i < 10; i++) {
            value += 1;
        }

    }
    public synchronized int getValue(){
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncMain1 syncMain1 = new SyncMain1();
        List<Thread> list =new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() ->{
                syncMain1.addValue();
                System.out.println(syncMain1.getValue());
            });
            list.add(thread);

        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).start();
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }


    }
}
