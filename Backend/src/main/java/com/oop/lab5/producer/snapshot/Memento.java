package com.oop.lab5.producer.snapshot;

import com.oop.lab5.producer.model.Machine;
import com.oop.lab5.producer.model.Product;
import com.oop.lab5.producer.model.ProductQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Memento {
    private HashMap<Long, Machine> machines = new HashMap<>(); // Machines colors
    private HashMap<Long, ProductQueue> queues = new HashMap<>(); // queues products
    private Queue<Product> products =  new LinkedList<>();

    public Memento() {}

    public Memento(HashMap<Long, Machine> machinesState, HashMap<Long, ProductQueue> queuesState, Queue<Product> productsState) {
        this.machines = machinesState;
        this.queues = queuesState;
        this.products = productsState;
    }

    public HashMap<Long, Machine> getMachines() {
        return this.machines;
    }

    public HashMap<Long, ProductQueue> getQueues() {
        return this.queues;
    }

    public Queue<Product> getProducts() {
        return this.products;
    }
}
