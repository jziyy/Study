package com.example.demo.lambda.stream;


import java.util.*;

public class Stream_catch {
    public static void main(String[] args) {

//        Arrays.asList(1,2,12,42).parallelStream().map(s -> s + "").
//                filter(s ->Integer.parseInt(s) > 12).findAny();

        List<String> list = Arrays.asList("1221");
        Optional<String> max = list.parallelStream().findFirst();
        System.out.println(max.orElseGet(()->  Locale.getDefault().getDisplayName()));
        String s = "";
        List<String> list1 = new ArrayList<>();
        max.ifPresent(list1::add);
        System.out.println(list1);
        Hashtable<String,String> h = new Hashtable<>();


    }
}
