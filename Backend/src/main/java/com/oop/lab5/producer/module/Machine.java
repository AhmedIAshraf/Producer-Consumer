package com.oop.lab5.producer.module;

public class Machine {
    private long id;
    private String color;
    private boolean state = true;
    private Product currentProduct;
    private long rate;  // will be generated randomly in this class
    private ProductQueue connectedQueue;

    public Machine(long id) {
        this.id = id;
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

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public long getRate() {
        return rate;
    }

    public ProductQueue getConnectedQueue() {
        return connectedQueue;
    }

    public void setConnectedQueue(ProductQueue connectedQueue) {
        this.connectedQueue = connectedQueue;
    }
}
