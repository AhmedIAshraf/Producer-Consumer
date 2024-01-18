package com.oop.lab5.producer.module;

import java.util.List;

public class Machine implements IObservable {
    private long id;
    private String color; // Machine color will be the same of current product color
    private boolean state = true; // indicates whether the machine is busy or not
    private Product currentProduct;
    private long rate;  // will be generated randomly in this class
    private List<ProductQueue> connectedQueues; // Queues which supply the machine with products <which are observers>

    public Machine(long id) {
        this.id = id;
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
        this.color = currentProduct.getColor();
    }

    public long getRate() {
        return rate;
    }

    public List<ProductQueue> getConnectedQueues() {
        return connectedQueues;
    }

    public void setConnectedQueues(List<ProductQueue> connectedQueues) {
        this.connectedQueues = connectedQueues;
    }

    @Override
    public void notifyQueues() {
        //inform the connected queues that the machine is ready and get the product from them
    }
}
