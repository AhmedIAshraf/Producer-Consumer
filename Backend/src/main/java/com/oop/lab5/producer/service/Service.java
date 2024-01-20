package com.oop.lab5.producer.service;

import com.oop.lab5.producer.module.Machine;
import com.oop.lab5.producer.module.Product;
import com.oop.lab5.producer.module.ProductQueue;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private long productID = 1;
    private long machineID = 1;
    private long queueID = 1;
    protected HashMap<Long, Machine> machines;
    protected HashMap<Long, ProductQueue> queues;
    protected Queue<Product> products;

    public Service() {
        this.machines = new HashMap<>();
        this.queues = new HashMap<>();
        this.products = new LinkedList<>();
    }

    void run(){
        
    }

    public void addProducts(long number) {
        while (number < 0) {
            Product p = new Product(this.productID++);
            this.products.add(p);
            number--;
        }
    }

    public void addMachine() {
        Machine m = new Machine(this.machineID);
        this.machines.put(this.machineID++, m);
    }

    public void addQueue() {
        ProductQueue q = new ProductQueue(this.queueID);
        if (this.queues.isEmpty())
            q.setProducts(this.products);

        this.queues.put(this.queueID++, q);
    }

    public void connect(long srcID, long destID, boolean isSrcMachine) {
        if (isSrcMachine) {
            Machine srcM = this.machines.get(srcID);
            ProductQueue destQ = this.queues.get(destID);
            srcM.setDestQueue(destQ);
        }else {
            Machine destM = this.machines.get(destID);
            ProductQueue srcQ = this.queues.get(srcID);
            destM.attachQueue(srcQ);
        }
    }

    public ProductQueue outputStream() {
        for (ProductQueue q : this.queues.values()) {
            if (q.getConnectedMachines().isEmpty())
                return q;
        }
        return null;
    }

    public void board() {
        System.out.println("Queues");
        for (long i = 1; i < this.queues.size() + 1; ++i) {
            System.out.println(queues.get(i).toString());
        }

        System.out.println("Machines");
        for (long i = 1; i < this.machines.size() + 1; ++i) {
            System.out.println(machines.get(i).toString());
        }
    }

    public boolean isFinished() { // check if the program finished or not
        return false;
    }

    public String getStatus() {
        return "";
    }

    public String replay() {
        
    }
}

// saving steps in order to sending them to frontend