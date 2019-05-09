package com.example.demo.lambda.stream;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain {
    /**
     * 流的操作不会对原有的流进行修改，在进行相关api操作时，实际上时产生了一个新的流
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /**
         *  生成一个顺序流
        */
            Stream<String> stringStream = Files.lines(Paths.get("F:\\项目2\\新建文件夹 (10)\\study\\src\\main\\java\\com\\example\\demo\\lambda\\stream\\zhy.txt"));
        /**
         *  生成一个并行流(这个流的操作会自动进行并发操作)
         */
            Stream<String> stringStream1 = stringStream.parallel();

        /**
         *    Stream.map(Function function)      进行map操作传入一个function
         *    功能主要是对流中所有元素进行操作并返回一个新的流(返回值的类型随意)
         *    Function 是一个有返回值的函数（可以传递参数下面的s对应的就是stringStream流中的每个元素），返回值即新的流的内容
         */
        Stream<String> stringStream2 = stringStream.map(s -> s.split("，")[0]);

        /**
         *  Stream.filter(Predicate perdicate) 进行filter会进行过滤操作
         *  Predicate是一个有返回值的函数，返回值为boolean,如果返回的是true该元素就会被保留，如果返回的是false就会别过滤掉
         */
        Stream<String> stringStream3 =stringStream2.filter(s -> s.contains("花"));

        /**
         * Stream.count() 进行流的计数操作
         * 返回值是一个int型返回是该流中包含的数量
         */
         stringStream3.count() ;

        /**
         * Stream 的创建 返回值是一个Stream流
         *  包含startindex 索引上的值，不包含enindex
         * 使用Arrays.stream(Arrays arrays,int startindex,int enindex)
         *
         * 如果将整个数组转换为流可以使用 Arrays.stream(Arrays arrays)
         *
         *
         */
        String [] strings = new String[]{"12","112","343","23"};
        Arrays.stream(strings,1,2) ;
        Arrays.stream(strings) ;

        


    }
}
