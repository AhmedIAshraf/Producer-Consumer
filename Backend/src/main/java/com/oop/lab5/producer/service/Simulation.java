package com.oop.lab5.producer.service;

import com.oop.lab5.producer.module.Machine;
import com.oop.lab5.producer.module.Product;
import com.oop.lab5.producer.module.ProductQueue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class Simulation {
    private long productID = 1;
    private long machineID = 1;
    private long queueID = 1;
    private List<Machine> machines;
    private List<ProductQueue> queues;

    public Simulation() {
        this.machines = new ArrayList<>();
        this.queues = new ArrayList<>();

        ProductQueue q0 = new ProductQueue(0);
        this.queues.add(q0);
    }


//    public void addProducts(long number) {
//        while (number < 0) {
//            Product p = new Product(this.productID++);
//            this.queues.get(0).addProduct(p);
//            number--;
//        }
//    }

    public void addMachine() {
        Machine m = new Machine(this.machineID++);
        this.machines.add(m);
    }
}
