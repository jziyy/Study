package com.example.demo.test.demo.trycatch;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println(aaa());
    }
    public static Integer aaa(){
        int i =1;
        try{
            i++;
            int a = i/0;
        }catch (Exception e){
            return i++;
        }
        finally {
            return i++;
        }
    }
}
