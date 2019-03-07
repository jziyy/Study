package com.example.demo.arithmetic.stack;

import javax.xml.soap.Node;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Stack_Array implements Stack{
    public static void main(String[] args) {

    }
    //初始容量
    private int initCapacity;
    //栈定元素索引
    private int top;
    //储存数组
    private Object [] stack;
    //已使用的长度
    private int size;


    //扩容方法
    private void dilatation(int capacity){
        int newCapacity = 0;
        if (capacity > initCapacity){
            newCapacity = initCapacity + initCapacity >>1;
            this.stack = Arrays.copyOf(this.stack,newCapacity);
            return;
        }
        if (newCapacity < capacity){
            dilatation(capacity);
        }



    }



    Stack_Array(int initcapacity){
        this.initCapacity = initcapacity;
        stack = new Object[initcapacity];

    }

    @Override
    public void isEmpty() {

    }

    @Override
    public Integer search() {
        return null;
    }

    @Override
    public void pop() {

    }

    @Override
    public boolean push(Object o) {
        return false;
    }

    @Override
    public Object peek() {
        return null;
    }
}
