package com.example.demo.arithmetic;

public class Arithmetic1 {
   public static  Integer [] array = {6,2,5,5,4,5,6,3,7,6};
    public static void main(String[] args) {
        System.out.println(fun(10000));
    }
    public static Integer fun(int num){
        int sum = 0;
        while (num/10!=0){
            sum +=array[(num%10)];
            num/=10;
        }
        sum += array[num];
        return sum;
    }
}
