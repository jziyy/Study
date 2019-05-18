package com.example.demo.com.lambda.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream_generate {
    public static void main(String[] args) {
        int i =1;
//        Stream<Object> stream = Stream.generate(Math::random);
//        stream.parallel().forEach(System.out::println);
        Stream<Integer> stream = Stream.iterate(1,s -> ++s);
        //stream.parallel().forEach(System.out::println);
        try (Stream<String> line = Files.lines(Paths.get("F:\\项目2\\新建文件夹 (10)\\study\\src\\main\\resources\\statis\\zhy.txt"))){
            line.forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());



    }
}
