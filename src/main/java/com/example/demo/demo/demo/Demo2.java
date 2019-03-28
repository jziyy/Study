package com.example.demo.demo.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    static class aaa{
        List<String> list =new ArrayList<>();

    }

    public static void main(String[] args) {
        Equals equals =new Equals();
        aaa a =new aaa();
        List<String> aa = new ArrayList<>();
        aa.add("aa");
        equals.list.addAll(aa);
        System.out.println(equals.list);
    }
}
