package com.oop.lab5.producer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.observer.IObservable;
import com.oop.lab5.producer.service.ProductionLineService;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Machine implements IObservable, Runnable {
    private ProductionLineService service;
    private Thread thread;
    private long id;
    private String color = ""; // Machine color will be the same of current product color
    private boolean state = true; // indicates whether the machine is busy or not
    private Product currentProduct;
    private long serviceTime;  // will be generated randomly in this class
    private List<ProductQueue> connectedQueues = new ArrayList<>(); // Queues which supply the machine with products <which are observers>
    private ProductQueue destQueue;

    public Machine(long id) {
        this.id = id;
        this.serviceTime = (long) (Math.random() * 10) + 1; // creating random rate !!will be changed!!
        this.serviceTime = 1;
        this.service = ProductionLineService.getInstance();
        System.out.println("Service time " + serviceTime);
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

    public void addProduct(Product product) throws InterruptedException, JsonProcessingException {
//        System.out.println("after sending product ");
//        service.autoSave(); // -->
        this.currentProduct = product;
        this.color = currentProduct.getColor(); // --> null pointer sometimes
        System.out.println("after receiving product ");
        service.autoSave(); // --
        System.out.println("classmID" + this.id);
        Thread.sleep(this.serviceTime * 1000);
        this.destQueue.addProduct(this.currentProduct);
        this.currentProduct = null;
        this.color = "";
        System.out.println("after processing product ");
        service.autoSave(); // -->
//        this.run();
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

    public ProductQueue getDestQueue() {
        return destQueue;
    }

    public void setDestQueue(ProductQueue destQueue) {
        this.destQueue = destQueue;
    }

    @Override
    public void attachQueue(ProductQueue queue) { // Queue is source
        this.connectedQueues.add(queue);
        queue.connectToMachine(this);
    }

    @Override
    public void notifyQueues() throws InterruptedException,JsonProcessingException {
        //inform the connected queues that the machine is ready and get the product from them
        for (ProductQueue queue : this.connectedQueues)
            queue.updateState(this);
    }

    public Thread process() {
        Thread thread = new Thread(this);
        thread.start(); // call run
        return thread;
    }

    @Override
    public void run() {
        while (true) {
            if (service.outputStream().getProducts().size() == service.productsNo())
                break;
//            System.out.println("size");
//            System.out.println(service.productsNo());
            this.state = true;
            try {
                this.notifyQueues();
            } catch (InterruptedException  | JsonProcessingException e ) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("state", state);
        json.put("color", color);
        json.put("currentProduct", currentProduct);
        json.put("serviceTime", serviceTime);
        json.put("connectedQueues", connectedQueues);
        json.put("destQueue", destQueue);

        return json.toString();
    }
}