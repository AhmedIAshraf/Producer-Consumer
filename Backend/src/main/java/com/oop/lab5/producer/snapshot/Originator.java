package com.oop.lab5.producer.snapshot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oop.lab5.producer.model.Machine;
import com.oop.lab5.producer.model.Product;
import com.oop.lab5.producer.model.ProductQueue;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Originator {
    private HashMap<Long, Machine> machines = new HashMap<>(); // Machines colors
    private HashMap<Long, ProductQueue> queues = new HashMap<>(); // queues products
    private Queue<Product> products =  new LinkedList<>();

    public void addMachines (HashMap<Long, Machine> machines) {
        this.machines = machines;
    }

    public void addQueues (HashMap<Long, ProductQueue> queues){
        this.queues = queues;
    }

    public void addProducts(Queue<Product> products) { this.products = products; }

    public void clear () {
        this.machines.clear();
        this.queues.clear();
        this.products.clear();
    }

    public HashMap<Long, Machine> getMachines () {
        return this.machines;
    }

    public HashMap<Long, ProductQueue> getQueues () {
        return this.queues;
    }

    public Queue<Product> getProducts() { return this.products; }

    public Memento saveStateToMemento () {
        return new Memento(this.machines, this.queues, this.products);
    }

    public void getStateFromMemento (Memento memento) {
        this.machines = memento.getMachines();
        this.queues = memento.getQueues();
        this.products = memento.getProducts();
    }
}
