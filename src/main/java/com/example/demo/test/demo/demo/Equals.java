package com.example.demo.test.demo.demo;

import java.io.File;
import java.util.Arrays;

public class Equals {
    public static void main(String[] args) {
        File file = new File("E:\\work\\新建文件夹 (2) - 副本 - 副本");
        File [] files = file.listFiles();
        Arrays.sort(files,(s1,s2)-> Integer.parseInt(s1.getName().split("\\.")[0].trim()) -
                Integer.parseInt(s2.getName().split("\\.")[0].trim()));
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);

           files[i].renameTo(new File("E:\\work\\截图\\" + (i+2) + ".jpg"));
            System.out.println(files[i]);

        }

    }
}
