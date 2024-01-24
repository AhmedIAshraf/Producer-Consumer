package com.oop.lab5.producer.model;

import com.oop.lab5.producer.service.RandomColorGenerator;

public class Product {
    private long id;
    private final String color;
    private final long rate; // will be generated randomly in this class
    private boolean hasPart = false;

    public Product(long id) {
        this.id = id;
        this.color = RandomColorGenerator.generateRandomColor(); // creating random color
        this.rate = (int) (Math.random() * 30) + 1; // creating random rate !!will be changed!!
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

    public boolean isHasPart() {
        return hasPart;
    }

    public void setHasPart(boolean hasPart) {
        this.hasPart = hasPart;
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
