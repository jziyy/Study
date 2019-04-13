package com.example.demo.lambda.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_1 {
    public static void main(String[] args) throws IOException {
//        String [] a =new String[10];
//
//        Stream.of(a).forEach(System.out::println);
//        Stream<String> stream = Stream.of("1","1");
//        IntStream i = IntStream.of(1,2,3,4,5);
//        DoubleStream doubleStream = DoubleStream.of(1,2,3,4);
//        i.forEach(System.out::println);
//        doubleStream.forEach(System.out::println);
//        stream.forEach(System.out::println);
          Stream<String> stringStream = Files.lines(Paths.get(""));
          Predicate<String> predicate = (s)->s.length()>2;
          stringStream.filter(predicate).forEach(System.out::println);




    }
}
