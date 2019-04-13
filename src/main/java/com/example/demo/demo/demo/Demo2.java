package com.example.demo.demo.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) {
        Demo_Username username =new Demo_Username();
        username.list.addAll(Arrays.asList(new String[10]));
        System.out.println(username.list);
    }
}
