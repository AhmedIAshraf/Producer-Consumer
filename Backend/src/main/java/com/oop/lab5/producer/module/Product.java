package com.oop.lab5.producer.module;

public class Product {
    private long id;
    private String color; //will be generated randomly in this class
    private long rate; //will be generated randomly in this class

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public long getRate() {
        return rate;
    }
}
