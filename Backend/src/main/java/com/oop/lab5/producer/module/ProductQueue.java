package com.oop.lab5.producer.module;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductQueue {
    private long id;
    private List<Machine> ccnnectedMachines = new ArrayList<>();
    private Queue<Product> products = new PriorityQueue<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Machine> getCcnnectedMachines() {
        return ccnnectedMachines;
    }

    public void connectMachine(Machine machine) {
        this.ccnnectedMachines.add(machine);
    }

    public Queue<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
