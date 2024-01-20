package com.oop.lab5.producer.module;

import com.oop.lab5.producer.service.RandomColorGenerator;

public class Product {
    private long id;
    private String color;
    private long rate; // will be generated randomly in this class

    public Product(long id) {
        this.id = id;
        this.color = RandomColorGenerator.generateRandomColor(); // creating random color
        this.rate = (int) (Math.random() * 10) + 1; // creating random rate !!will be changed!!
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", rate=" + rate +
                '}';
    }
}
