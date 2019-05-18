package com.example.demo.com.lambda.consumer;

public class Child {
    private int price;
    private String name;

    public Child(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
