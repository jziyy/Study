package com.example.demo.com.regular;


public class NotChinese {
    public static void main(String[] args) {
        String s = "455asds6a4faaj月月";
        System.out.println(s.replaceAll("[^\\u4e00-\\u9fa5]",""));
        System.out.println("\u4e02");
    }
}
