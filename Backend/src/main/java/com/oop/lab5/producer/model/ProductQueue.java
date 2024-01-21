package com.oop.lab5.producer.model;

import com.oop.lab5.producer.observer.IObserver;
import com.oop.lab5.producer.service.ProductionLineService;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductQueue implements IObserver {
    private long id;
    private List<Machine> connectedMachines = new ArrayList<>(); // destination Machines
    private Queue<Product> products = new LinkedList<>();

    public ProductQueue(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Machine> getConnectedMachines() {
        return connectedMachines;
    }

    public void connectToMachine(Machine machine) {
        this.connectedMachines.add(machine);
    }

    public void setProducts(Queue<Product> products) {
        this.products = products;
    }

    public Queue<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public void updateState(Machine machine) throws InterruptedException {
        // change the state of the machine to be busy and send the product to the machine
        // here will be the logic of sending the product to the machine
        if (this.products.isEmpty())
            return;

        machine.setState(false);
        machine.addProduct(this.products.poll());
       // service.getInstance().autoSave();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("connectedM", connectedMachines);
        json.put("products", products);
        json.put("id", id);

        return json.toString();
    }
}
