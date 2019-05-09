package com.example.demo.demo.demo;

import java.util.*;

public class Demo2 {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"1");
        int b = 1 + Integer.parseInt(map.get(1).toString());
        System.out.println(b);
    }
}
