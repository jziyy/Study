package com.example.demo.lambda.function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer,Integer> function = e -> e+=100;
    }
}
