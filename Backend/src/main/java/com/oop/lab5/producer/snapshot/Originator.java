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
    private HashMap<Integer, Machine> machines = new HashMap<>(); // Machines colors
    private HashMap<Integer, ProductQueue> queues = new HashMap<>(); // queues products
    private Queue<Product> products =  new LinkedList<>();

    public Originator(HashMap<Integer, Machine> machines, HashMap<Integer, ProductQueue> queues, Queue<Product> products) {
        this.machines = machines;
        this.queues = queues;
        this.products = products;
    }

    public Originator() {}

    public HashMap<Integer, Machine> getMachines() {
        return this.machines;
    }

    public HashMap<Integer, ProductQueue> getQueues() {
        return this.queues;
    }

    public Queue<Product> getProducts() {
        return this.products;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.machines, this.queues, this.products);
    }

    public void getStateFromMemento(Memento memento) {
        this.machines = memento.getMachines();
        this.queues = memento.getQueues();
        this.products = memento.getProducts();
    }

    public void addQueues(HashMap<Integer, ProductQueue> queues) {
        this.queues = queues;
    }

    public void addMachines(HashMap<Integer, Machine> machines) {
        this.machines = machines;
    }

    public void addProducts(LinkedList<Product> products) {
        this.products = products;
    }
}

