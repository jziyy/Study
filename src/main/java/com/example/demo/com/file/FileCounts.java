package com.example.demo.com.file;

import java.io.File;

public class FileCounts {
    public static void main(String[] args) {
        System.out.println(getcounts(new File("E:\\work\\表格梳理")));
    }
    public static Integer getcounts(File file){

        int count = file.listFiles().length;

        int temp =0;

        File [] files = file.listFiles(File::isDirectory);

        if (files.length ==0){
            return count;
        }
        temp = count - files.length;
        for (int i = 0; i < files.length; i++) {
           temp  += getcounts(files [i]);
        }

        return temp;
    }
}
