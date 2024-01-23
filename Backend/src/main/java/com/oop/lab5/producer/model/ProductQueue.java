package com.oop.lab5.producer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oop.lab5.producer.observer.IObserver;
import com.oop.lab5.producer.service.ProductionLineService;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductQueue implements IObserver {
    private final long id;
    private final List<Machine> connectedMachines = new ArrayList<>(); // destination Machines
    private Queue<Product> products = new LinkedList<>();

    public ProductQueue(long id) {
        this.id = id;
    }

    public List<Machine> getConnectedMachines() {
        return new ArrayList<>(connectedMachines);
    }

    public void connectToMachine(Machine machine) {
        this.connectedMachines.add(machine);
    }

    public void setProducts(Queue<Product> products) {
        this.products = products;
    }

    public Queue<Product> getProducts() {
        return new LinkedList<>(products);
    }

    public synchronized void addProduct(Product product) {
        this.products.add(product);
    }

    public synchronized Product getProduct(){
        return this.products.poll();
    }

    @Override
    public void updateState(Machine machine) throws InterruptedException, JsonProcessingException {
        // change the state of the machine to be busy and send the product to the machine
        // here will be the logic of sending the product to the machine
        if (this.products.isEmpty())
            return;
        machine.setState(false);
        machine.addProduct(getProduct());
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("connectedM", connectedMachines);
        json.put("products", products);

        return json.toString();
    }
}