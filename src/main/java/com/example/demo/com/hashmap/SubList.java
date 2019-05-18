package com.example.demo.com.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SubList {
    public static void main(String[] args) {
        //创建一个list集合并对其赋值
        List<String> list = new ArrayList<>();
        Stream.iterate(1, s -> ++s).limit(10).forEach(s ->list.add(s + ""));
        System.out.println(list);
        //获取到想要截取的位置
        List<String> list1 = list.subList(1, 3);
        //对位置元素进行清除
        list1.clear();
        System.out.println(list1);
        System.out.println(list);

    }
}
