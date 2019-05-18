package com.example.demo.com.list;

import java.util.ArrayList;
import java.util.List;

public class ForL {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("2");
        list.add("a");
        list.add("2");
        list.add("a");
        list.add("2");
        list.add("a");
        list.add("2");
        list.add("a");
        list.add("2");
        for (int i = 0; i < list.size(); i++) {
            if (list.size() > 3){
                list.remove(2);
            }
        }
        System.out.println(list);
    }
}
