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

    public void addMachine (Machine machine) {
        machines.put(machine.getId(), machine);
    }

    public void addQueue (ProductQueue queue){
        queues.put(queue.getId(), queue);
    }

    public void addProduct(Product product) { products.add(product); }

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

    @Override
    public String toString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("colors", gson.toJson(machines));
        jsonObject.put("queues", gson.toJson(queues));
        jsonObject.put("products", gson.toJson(products));

        return jsonObject.toString(2);
    }
}
