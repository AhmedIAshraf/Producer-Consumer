package com.oop.lab5.producer.module;

import java.util.ArrayList;
import java.util.List;

public class Machine implements IObservable, Runnable {
    private Thread thread;
    private long id;
    private String color = ""; // Machine color will be the same of current product color
    private boolean state = true; // indicates whether the machine is busy or not
    private Product currentProduct;
    private long serviceTime;  // will be generated randomly in this class
    private List<ProductQueue> connectedQueues = new ArrayList<>(); // Queues which supply the machine with products <which are observers>

    public Machine(long id) {
        this.id = id;
        this.serviceTime = (int) (Math.random() * 10) + 1; // creating random rate !!will be changed!!
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

    public void addProduct(Product product) {
        this.currentProduct = product;
        this.color = currentProduct.getColor();
    }

    public long getServiceTime() {
        return serviceTime;
    }

    public List<ProductQueue> getConnectedQueues() {
        return connectedQueues;
    }

    public void setConnectedQueues(List<ProductQueue> connectedQueues) {
        this.connectedQueues = connectedQueues;
    }

    @Override
    public void attachQueue(ProductQueue queue) {
        this.connectedQueues.add(queue);
    }

    @Override
    public void notifyQueues() {
        //inform the connected queues that the machine is ready and get the product from them
        for (ProductQueue queue : this.connectedQueues)
            queue.setMachineState(this.state);
    }

    @Override
    public void run() {

    }
}
