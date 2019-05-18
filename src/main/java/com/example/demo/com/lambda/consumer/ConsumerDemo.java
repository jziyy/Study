package com.example.demo.com.lambda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer函数主要可以用于打印信息consumer.accept(s)没有返回值，也可以作为一个
 * 函数来批量处理一个集合中的对象的内容，基础类型改变不了只能改变对象，如果打算批
 * 量处理基础类型可以使用Function函数
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        List<Child> list = new ArrayList<Child>();
        list.add(new Child(1, "daasd"));
        list.add(new Child(1, "daasd"));
        list.add(new Child(1, "daasd"));
        list.add(new Child(1, "daasd"));
        Consumer<Child> change = e -> e.setPrice(e.getPrice() + 100);
        list.forEach(change);
        list.forEach(System.out::println);
        List<String> list1 = new ArrayList<>();
        list1.add("asdsd");
        list1.add("asdsd");
        list1.add("asdsd");
        list1.add("asdsd");
        //String不好使 基础类型不好使
        Consumer<String> consumer = e ->e += "111111";
        list1.forEach(consumer);
        list1.forEach(System.out::println);
        List<Integer> list2 = new ArrayList<>();
        list2.add(23);
        list2.add(23);
        list2.add(23);
        list2.add(23);
        Consumer<Integer> aaa = e->e+=111;
        list2.forEach(aaa);
        System.out.println(list2);
    }
}