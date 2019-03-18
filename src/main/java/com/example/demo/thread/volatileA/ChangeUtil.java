package com.example.demo.thread.volatileA;

public class ChangeUtil {

    int x =0;
    volatile boolean v = false;

    public void write(){
        x = 34;
        v = true;
    }
    public void read (){
        if (v =true){
            System.out.println(x);

        }
    }


}
