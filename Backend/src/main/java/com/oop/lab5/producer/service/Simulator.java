package com.oop.lab5.producer.service;

import com.oop.lab5.producer.module.ProductQueue;

public class Simulator {
    private Simulator instance;

    private Service service;

    private Simulator() {}

    public Simulator getInstance() {
        if (this.instance == null)
            return new Simulator();
        return instance;
    }

    public void simulate() {
        ProductQueue outputQ = service.outputStream();
        while (outputQ.getProducts().size() < service.products.size()) {

        }
    }
}
// check that each machine is connected to at least one destination queue
// check that Q0 is the input stream