package com.example.demo.test;

public class TestStatic {
    public static void main(String[] args) {
        System.out.println(BX.c);
    }
}
class AX{
    static {
        System.out.println("A");
    }
}
class BX extends AX{
    static {
        System.out.println("b");

    }
    public static  String c ="c";
}
